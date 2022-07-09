package com.blue.callblock.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.blue.callblock.navigation.AppRoutes
import com.blue.callblock.navigation.NavHelper

@Composable
fun BottomNavBar(routes: AppRoutes, navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        routes.asListForTab().forEach { route ->
            BottomNavigationItem(
                onClick = {
                    NavHelper.navigateToTabScreen(navController, route.name)
                },
                selected = currentDestination?.hierarchy?.any { it.route == route.name } == true,
                icon = { Icon(route.icon, route.name) })
        }
    }
}