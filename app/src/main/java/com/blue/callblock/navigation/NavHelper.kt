package com.blue.callblock.navigation

import androidx.navigation.NavController

object NavHelper {
    fun navigateToNumberDetails(navController: NavController, phoneNumber: String) {
        navController.navigate(route = AppRoutes.NumberDetails.name + "/" + phoneNumber)
    }

    fun navigateToTabScreen(navController: NavController, tabName: String) {
        navController.navigate(tabName) {
            navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                    saveState = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}