package com.blue.callblock.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CallEventDao {
    @Query("SELECT * FROM CallEvent ORDER BY timestamp DESC")
    fun getAll(): LiveData<List<CallEvent>>

    @Query("SELECT * FROM CallEvent ORDER BY timestamp DESC LIMIT (:limit)")
    fun getAllWLimit(limit: Int): LiveData<List<CallEvent>>

    @Query("SELECT * FROM CallEvent WHERE phone_number IN(:phoneNumber) LIMIT 1")
    fun findByPhoneNumber(phoneNumber: String): CallEvent

    @Insert
    fun insertAll(vararg callEvent: CallEvent)

    @Delete
    fun delete(callEvent: CallEvent)
}