package com.blue.callblock.repository

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.blue.callblock.shared.CallType

/**
 * Handles storing callers that may have flags such as blocked or allowed.
 */
@Entity
data class Caller(
    @PrimaryKey @NonNull @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "blocked_time") val blockedTime: Long?,
    @ColumnInfo(name = "allowed_time") val allowedTime: Long?,
    @ColumnInfo(name = "call_type") val lastCallType: CallType
) {
    fun isAllowed(): Boolean {
        return this.allowedTime != null && this.allowedTime > 0L
    }

    fun isBlocked(): Boolean {
        return this.blockedTime != null && this.blockedTime > 0L
    }

    companion object {
        /**
         * Creates a new Caller object instance.
         * phoneNumber is mandatory.
         * flag and last call type are optional.
         */
        fun createNew(
            phoneNumber: String,
            allowedTime: Long?,
            blockedTime: Long?,
            lastCallType: CallType?
        ): Caller {
            return Caller(
                phoneNumber = phoneNumber,
                allowedTime = allowedTime,
                blockedTime = blockedTime,
                lastCallType = lastCallType ?: CallType.None
            )
        }
    }
}
