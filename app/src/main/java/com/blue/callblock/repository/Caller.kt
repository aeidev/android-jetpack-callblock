package com.blue.callblock.repository

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.blue.callblock.shared.CallType
import com.blue.callblock.shared.CallerFlags

/**
 * Handles storing callers that may have flags such as blocked or allowed.
 */
@Entity
data class Caller(
    @PrimaryKey @NonNull @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "flag") val flag: CallerFlags,
    @ColumnInfo(name = "flagged_time") val flaggedTime: Long?,
    @ColumnInfo(name = "call_type") val lastCallType: CallType
) {
    fun isAllowed(): Boolean {
        return this.flag == CallerFlags.ALLOW
    }

    fun isBlocked(): Boolean {
        return this.flag == CallerFlags.BLOCK
    }

    companion object {
        /**
         * Creates a new Caller object instance.
         * phoneNumber is mandatory.
         * flag and last call type are optional.
         */
        fun createNew(
            phoneNumber: String,
            flag: CallerFlags?,
            flaggedTime: Long?,
            lastCallType: CallType?
        ): Caller {
            return Caller(
                phoneNumber = phoneNumber,
                flag = flag ?: CallerFlags.NONE,
                flaggedTime = flaggedTime,
                lastCallType = lastCallType ?: CallType.None
            )
        }
    }
}
