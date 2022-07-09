package com.blue.callblock.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.blue.callblock.repository.AppPrefRepository
import com.blue.callblock.shared.AppPrefsKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val appPrefRepository: AppPrefRepository) :
    ViewModel() {
    var blockedNotificationsEnabled by mutableStateOf(true)
    var allowedNotificationsEnabled by mutableStateOf(true)

    init {
        blockedNotificationsEnabled = appPrefRepository.areBlockedNotificationsEnabled()
        allowedNotificationsEnabled = appPrefRepository.areAllowedNotificationsEnabled()
    }

    fun setBlockedNotifications(enabled: Boolean) {
        blockedNotificationsEnabled = enabled
        appPrefRepository.setBoolean(AppPrefsKeys.blocked_caller_notifications, enabled)
    }

    fun setAllowedNotifications(enabled: Boolean) {
        allowedNotificationsEnabled = enabled
        appPrefRepository.setBoolean(AppPrefsKeys.allowed_caller_notifications, enabled)
    }
}