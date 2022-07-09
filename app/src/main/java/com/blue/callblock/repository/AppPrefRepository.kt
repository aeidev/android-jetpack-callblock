package com.blue.callblock.repository

import com.blue.callblock.shared.AppPrefsKeys
import com.tencent.mmkv.MMKV
import javax.inject.Inject

class AppPrefRepository @Inject constructor(private val appPreference: MMKV?) {
    fun setBoolean(key: String, value: Boolean) {
        appPreference?.encode(key, value)
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        //some weirdness going on with the default value and still potentially returning null...
        return appPreference?.decodeBool(key, default) ?: default
    }

    fun setString(key: String, value: String) {
        appPreference?.encode(key, value)
    }

    fun getString(key: String): String? {
        return appPreference?.decodeString(key)
    }

    fun areBlockedNotificationsEnabled(): Boolean {
        return appPreference?.getBoolean(AppPrefsKeys.blocked_caller_notifications, true) ?: true
    }

    fun areAllowedNotificationsEnabled(): Boolean {
        return appPreference?.getBoolean(AppPrefsKeys.allowed_caller_notifications, true) ?: true
    }
}