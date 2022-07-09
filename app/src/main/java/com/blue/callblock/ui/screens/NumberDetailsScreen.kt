package com.blue.callblock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.blue.callblock.R
import com.blue.callblock.model.NumberDetailsViewModel


@Composable
fun BlueCustomButton(label: String, onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Text(label)
    }
}

@Composable
fun NumberDetailsScreen(viewModel: NumberDetailsViewModel, navController: NavController) {
    val callerState = viewModel.caller.observeAsState()
    Surface {
        Scaffold(
            topBar = {
                TopAppBar(content = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                    Text(text = "Number information")
                })
            },
            content = { padding ->
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .padding(horizontal = 12.dp, 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(24.dp, 32.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    ) {
                        Text(viewModel.phoneNumber!!)
                    }
                    Spacer(modifier = Modifier.padding(0.dp, 32.dp))

                    if (callerState.value?.isBlocked() == true) {
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_unblock_number),
                            onClick = { viewModel.removeCallerFlags() })
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_allow_number),
                            onClick = { viewModel.allowCaller() })
                    } else if (callerState.value?.isAllowed() == true) {
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_unallow_number),
                            onClick = { viewModel.removeCallerFlags() })
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_block_number),
                            onClick = { viewModel.blockCaller() })
                    } else {
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_block_number),
                            onClick = { viewModel.blockCaller() })
                        BlueCustomButton(
                            label = stringResource(id = R.string.button_allow_number),
                            onClick = { viewModel.allowCaller() })
                    }
                }
            })
    }
}