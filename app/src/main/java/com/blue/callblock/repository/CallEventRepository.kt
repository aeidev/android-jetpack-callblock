package com.blue.callblock.repository

import androidx.lifecycle.LiveData
import com.blue.callblock.AppLogger
import javax.inject.Inject

class CallEventRepository @Inject constructor(private val callEventDao: CallEventDao) {
    fun getCallEvents() = callEventDao.getAll()

    fun getCallEventsWLimit(limit: Int): LiveData<List<CallEvent>> {
        return callEventDao.getAllWLimit(limit)
    }

    fun putRecentCall(call: CallEvent) {
        AppLogger.logD("RCP", "putting call: $call")
        callEventDao.insertAll(call)
    }
}