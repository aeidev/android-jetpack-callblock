package com.blue.callblock.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.blue.callblock.Constants
import com.blue.callblock.model.*
import com.blue.callblock.ui.components.BottomNavBar
import com.blue.callblock.ui.screens.*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun AppNavigation(
    startingRoute: String = AppRoutes.Home.name,
    routes: AppRoutes = AppRoutes
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        modifier = Modifier.displayCutoutPadding(),
        bottomBar = {
            if (navBackStackEntry?.destination?.route?.startsWith(AppRoutes.NumberDetails.name) != true) {
                BottomNavBar(
                    routes = routes,
                    navController = navController
                )
            }
        }) {
        NavHost(navController = navController, startDestination = startingRoute) {
            composable(AppRoutes.Home.name) {
                val viewModel = hiltViewModel<HomeViewModel>()
                HomeScreen(viewModel = viewModel, navController)
            }
            composable(AppRoutes.Manage.name) {
                val viewModel = hiltViewModel<ManageViewModel>()
                ManageScreen(viewModel = viewModel, navController)
            }
            composable(AppRoutes.Settings.name) {
                val viewModel = hiltViewModel<SettingsViewModel>()
                SettingsScreen(viewModel = viewModel, navController = navController)
            }
            composable(
                route = AppRoutes.NumberDetails.name + "/{phoneNumber}",
                deepLinks = listOf(navDeepLink { uriPattern = "${Constants.APP_URI}{phoneNumber}" })
            ) {
                val viewModel = hiltViewModel<NumberDetailsViewModel>()
                NumberDetailsScreen(viewModel = viewModel, navController)
            }
            composable(AppRoutes.BlockList.name) {
                val viewModel = hiltViewModel<BlockedListViewModel>()
                BlockListScreen(viewModel = viewModel, navController = navController)
            }
            composable(AppRoutes.AllowList.name) {
                val viewModel = hiltViewModel<AllowedListViewModel>()
                AllowedListScreen(viewModel = viewModel, navController = navController)
            }
        }
    }

}
