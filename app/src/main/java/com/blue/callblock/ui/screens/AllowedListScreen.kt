package com.blue.callblock.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blue.callblock.helpers.DateHelper
import com.blue.callblock.model.AllowedListViewModel
import com.blue.callblock.model.BlockedListViewModel
import com.blue.callblock.navigation.AppRoutes
import com.blue.callblock.navigation.NavHelper
import com.blue.callblock.repository.CallEvent
import com.blue.callblock.repository.Caller
import com.blue.callblock.ui.components.CallListItem
import com.blue.callblock.ui.components.CheckBoxCard
import com.blue.callblock.ui.components.ListActionCard

@Composable
fun AllowedListScreen(viewModel: AllowedListViewModel, navController: NavController) {
    val callersList: State<List<Caller>> =
        viewModel.allowedList.observeAsState(initial = listOf())

    Scaffold(
        topBar = {
            TopAppBar(content = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(text = "Allowed caller list", textAlign = TextAlign.Center)
            })
        }
    ) { padding ->
        Surface {
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(12.dp, 12.dp)
                    .fillMaxSize()
            ) {
                if (callersList.value.isEmpty()) {
                    Text(
                        text = "No allowed callers.",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(0.dp, 32.dp)
                    )
                } else {
                    LazyColumn {
                        items(callersList.value) { caller ->
                            ListActionCard(titleLabel = caller.phoneNumber, subTitleLabel = DateHelper.millisecondsToDate(caller.flaggedTime!!), onClick = { NavHelper.navigateToNumberDetails(navController, caller.phoneNumber) })
                        }
                    }
                }

            }
        }
    }

}