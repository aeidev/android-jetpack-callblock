package com.blue.callblock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.blue.callblock.model.SettingsViewModel
import com.blue.callblock.navigation.AppRoutes
import com.blue.callblock.ui.components.CheckBoxCard
import com.blue.callblock.ui.components.ListActionCard
import com.blue.callblock.ui.components.MissingRole
import com.blue.callblock.ui.components.ScreenHeader

@Composable
fun SettingsScreen(viewModel: SettingsViewModel, navController: NavController) {
    Surface {
        Column(
            modifier = Modifier
                .padding(12.dp, 0.dp)
                .fillMaxSize()
        ) {
            ScreenHeader(titleLabel = "Settings")
            CheckBoxCard(
                "Display blocked caller notifications",
                viewModel.blockedNotificationsEnabled,
                onClick = { enabled ->
                    viewModel.setBlockedNotifications(
                        enabled
                    )
                })
            CheckBoxCard(
                "Display allowed caller notifications",
                viewModel.allowedNotificationsEnabled,
                onClick = { enabled -> viewModel.setAllowedNotifications(enabled) })
            MissingRole()
        }
    }
}