package com.blue.callblock.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.blue.callblock.AppLogger
import com.blue.callblock.Constants
import com.blue.callblock.repository.Caller
import com.blue.callblock.repository.CallerRepository
import com.blue.callblock.shared.CallType
import com.blue.callblock.shared.CallerFlags
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberDetailsViewModel @Inject constructor(
    private val callerRepository: CallerRepository,
    savedState: SavedStateHandle
) : ViewModel() {
    val phoneNumber = savedState.get<String>("phoneNumber")
    val caller: LiveData<Caller> = callerRepository.getCallerByNumberLive(phoneNumber!!)

    fun blockCaller() {
        AppLogger.logAlways(Constants.APP_LOG_TAG, "ALLOW CALLER")
        CoroutineScope(Dispatchers.IO).launch {
            val c = Caller.createNew(
                phoneNumber = phoneNumber!!,
                flag = CallerFlags.BLOCK,
                flaggedTime = System.currentTimeMillis(),
                lastCallType = caller.value?.lastCallType ?: CallType.None
            )
            callerRepository.putCaller(c)
        }
    }

    fun allowCaller() {
        CoroutineScope(Dispatchers.IO).launch {
            val c = Caller.createNew(
                phoneNumber = phoneNumber!!,
                flag = CallerFlags.ALLOW,
                flaggedTime = System.currentTimeMillis(),
                lastCallType = caller.value?.lastCallType ?: CallType.None
            )
            callerRepository.putCaller(c)
        }
    }

    fun removeCallerFlags() {
        CoroutineScope(Dispatchers.IO).launch {
            val c = Caller.createNew(
                phoneNumber = phoneNumber!!,
                null,
                null,
                caller.value?.lastCallType ?: CallType.None
            )
            callerRepository.putCaller(c)
        }
    }
}