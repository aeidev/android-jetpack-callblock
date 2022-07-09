package com.blue.callblock.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.blue.callblock.shared.CallerFlags

@Dao
interface CallerDao {
    @Query("SELECT * FROM Caller")
    fun getAll(): List<Caller>

    @Query("SELECT * FROM Caller")
    fun getAllLive(): LiveData<List<Caller>>

    @Query("SELECT * FROM Caller WHERE phone_number IN(:phoneNumber) LIMIT 1")
    fun loadByPhoneNumberLive(phoneNumber: String): LiveData<Caller>

    @Query("SELECT * FROM Caller WHERE phone_number IN(:phoneNumber) LIMIT 1")
    fun loadByPhoneNumber(phoneNumber: String): Caller?

    @Query("SELECT * FROM Caller WHERE flag in(:flag)")
    fun getAllByCallFlag(flag: CallerFlags): LiveData<List<Caller>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recentCall: Caller)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(caller: Caller): Int
    fun insertOrUpdate(caller: Caller) {
        if (loadByPhoneNumber(caller.phoneNumber) != null) {
            update(caller)
        } else {
            insertAll(caller)
        }
    }

    @Delete
    fun delete(recentCall: Caller)
}