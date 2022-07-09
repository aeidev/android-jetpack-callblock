package com.blue.callblock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.blue.callblock.model.ManageViewModel
import com.blue.callblock.navigation.AppRoutes
import com.blue.callblock.ui.components.ListActionCard
import com.blue.callblock.ui.components.ScreenHeader
import com.blue.callblock.ui.components.ToggleCard

@Composable
fun ManageScreen(viewModel: ManageViewModel, navController: NavController) {

    Surface {
        Scaffold(modifier = Modifier.padding(12.dp, 0.dp), content = { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                ScreenHeader(
                    titleLabel = "Call rules",
                    subTitleLabel = "Setup rules for what callers the app should block or not block."
                )

                ListActionCard(
                    titleLabel = "Allowed callers",
                    subTitleLabel = "Manage your allowed caller list."
                ) {
                    navController.navigate(
                        route = AppRoutes.AllowList.name
                    )
                }

                ListActionCard(
                    titleLabel = "Blocked callers",
                    subTitleLabel = "Manage your blocked caller list."
                ) {
                    navController.navigate(
                        route = AppRoutes.BlockList.name
                    )
                }
                /**
                 * WIP
                ToggleCard(titleLabel = "Block all", state = viewModel.blockAllState)
                ListActionCard(
                    titleLabel = "Neighborhoods",
                    subTitleLabel = "Manage blocked neighborhoods."
                ) {
                    navController.navigate(
                        route = AppRoutes.AllowList.name
                    )
                }
                ListActionCard(
                    titleLabel = "Area codes",
                    subTitleLabel = "Manage blocked area codes."
                ) {
                    navController.navigate(
                        route = AppRoutes.AllowList.name
                    )
                } **/
            }
        })
    }
}