package com.blue.callblock.ui.components

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.blue.callblock.R
import com.blue.callblock.shared.PermissionAndRole
import com.blue.callblock.ui.theme.warningFont


@Composable
fun MissingRole() {
    val context = LocalContext.current
    val hasRole = remember { mutableStateOf(PermissionAndRole.hasCallScreeningService(context)) }
    val roleLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode != Activity.RESULT_OK) {
            return@rememberLauncherForActivityResult
        } else {
            hasRole.value = true
        }
    }
    PermissionAndRole.getRequestCallScreenRoleIntent(context)
    when (hasRole.value) {
        false -> {
            WarningCard {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    Text(
                        text = stringResource(id = R.string.warning_banner_missing_call_screen_role),
                        modifier = Modifier
                            .weight(3f, true)
                            .padding(start = 0.dp, top = 0.dp, end = 4.dp, bottom = 0.dp),
                        color = MaterialTheme.colors.warningFont,
                    )
                    Spacer(Modifier.weight(0.4f))
                    Text(
                        text = stringResource(id = R.string.button_enable),
                        modifier = Modifier
                            .weight(1f, true)
                            .clickable(onClick = {
                                roleLauncher.launch(
                                    PermissionAndRole.getRequestCallScreenRoleIntent(
                                        context
                                    )
                                )
                            })
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
        else -> {
            //allgood
        }
    }
}