package com.blue.callblock.repository

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.blue.callblock.shared.CallType

/**
 * RecentCall class handles storing individual call events.
 */
@Entity
data class CallEvent(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "call_id") val id: Int,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "timestamp") val timeStamp: Long,
    @ColumnInfo(name = "call_type") var callType: CallType
)