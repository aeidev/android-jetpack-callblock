package com.blue.callblock.repository

import androidx.lifecycle.LiveData
import javax.inject.Inject


class CallerRepository @Inject constructor(private val callerDao: CallerDao) {
    fun getCallerByNumberLive(number: String): LiveData<Caller> {
        return callerDao.loadByPhoneNumberLive(number)
    }

    suspend fun getCallerByNumber(number: String): Caller? {
        return callerDao.loadByPhoneNumber(number)
    }

    suspend fun putCaller(caller: Caller) {
        callerDao.insertOrUpdate(caller)
    }

    fun getAll(): LiveData<List<Caller>> {
        return callerDao.getAllLive()
    }

    fun getAllBlocked(): LiveData<List<Caller>> {
        return callerDao.getAllBlocked()
    }
    fun getAllAllowed(): LiveData<List<Caller>> {
        return callerDao.getAllAllowed()
    }
}