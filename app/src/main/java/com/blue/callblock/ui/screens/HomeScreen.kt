package com.blue.callblock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.blue.callblock.model.HomeViewModel
import com.blue.callblock.navigation.AppRoutes
import com.blue.callblock.navigation.NavHelper
import com.blue.callblock.repository.CallEvent
import com.blue.callblock.ui.components.MissingRole
import com.blue.callblock.ui.components.RecentCallList
import com.blue.callblock.ui.components.ScreenHeader


@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {
    val recentCalls: State<List<CallEvent>> =
        viewModel.recentCalls.observeAsState(initial = listOf())

    Surface {
        Column {
            MissingRole()
            Column(
                Modifier
                    .padding(12.dp, 0.dp)
                    .fillMaxWidth()
            ) {
                ScreenHeader(titleLabel = "Overview")
                RecentCallList(
                    recentCalls.value,
                    onItemClick = { mdn -> NavHelper.navigateToNumberDetails(navController, mdn) })
                Spacer(modifier = Modifier.padding(0.dp, 2.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        NavHelper.navigateToTabScreen(
                            navController,
                            AppRoutes.Manage.name
                        )
                    }) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(Dp.Unspecified, 28.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Manage your call rules")
                        Icon(
                            imageVector = Icons.Filled.KeyboardArrowRight,
                            contentDescription = "action icon"
                        )
                    }
                }
            }
        }
    }
}