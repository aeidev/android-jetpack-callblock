package com.blue.callblock.repository

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CallEvent::class, Caller::class], version = 1)
abstract class CallDatabase : RoomDatabase() {
    abstract fun recentCallDao(): CallEventDao
    abstract fun callerDao(): CallerDao
}