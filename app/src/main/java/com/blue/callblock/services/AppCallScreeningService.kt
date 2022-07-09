package com.blue.callblock.services

import android.net.Uri
import android.telecom.Call
import android.telecom.Call.Details.DIRECTION_INCOMING
import android.telecom.CallScreeningService
import android.telephony.PhoneNumberUtils
import com.blue.callblock.AppLogger
import com.blue.callblock.helpers.NotificationHelper
import com.blue.callblock.repository.AppPrefRepository
import com.blue.callblock.repository.CallEvent
import com.blue.callblock.repository.CallEventRepository
import com.blue.callblock.repository.CallerRepository
import com.blue.callblock.shared.CallType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AppCallScreeningService : CallScreeningService() {

    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.IO + job)

    @Inject
    lateinit var recentCallsRepository: CallEventRepository

    @Inject
    lateinit var appPrefRepository: AppPrefRepository

    @Inject
    lateinit var callerRepository: CallerRepository
    private val TAG = "AppCallScreening"
    override fun onScreenCall(callDetails: Call.Details) {
        if (callDetails.callDirection == DIRECTION_INCOMING && callDetails.handle != null) {
            val rawNumber = getPhoneNumberFromHandle(callDetails.handle)
            val parsedNumber = PhoneNumberUtils.formatNumberToE164(rawNumber, "US")
            val number = parsedNumber ?: rawNumber
            if (number.isNotBlank()) {
                val callEvent = CallEvent(
                    0,
                    number,
                    System.currentTimeMillis() - 1,
                    callType = CallType.Allowed
                )
                scope.launch {
                    val caller = callerRepository.getCallerByNumber(number)
                    val ourResponse = CallResponse.Builder()
                    if (caller?.isBlocked() == true) {
                        ourResponse.setRejectCall(true).setDisallowCall(true).setSilenceCall(true)
                        callEvent.callType = CallType.Blocked
                        if (appPrefRepository.areBlockedNotificationsEnabled()) {
                            NotificationHelper.doBlockedNotification(
                                context = applicationContext,
                                number
                            )
                        }
                    } else {
                        if (appPrefRepository.areAllowedNotificationsEnabled()) {
                            NotificationHelper.doAllowedNotification(
                                context = applicationContext,
                                number
                            )
                        }
                    }
                    recentCallsRepository.putRecentCall(callEvent)
                    respondToCall(callDetails, ourResponse.build())
                }
            }

        } else {
            AppLogger.logAlways(TAG, "Not screening call.")
        }
    }

    private fun getPhoneNumberFromHandle(handle: Uri): String {
        return handle.schemeSpecificPart
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}