package com.blue.callblock.ui.components

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SwitchBase(initialValue: Boolean) {
    val toggledState = remember { mutableStateOf(initialValue) }
    Switch(
        checked = toggledState.value,
        onCheckedChange = { toggledState.value = it }
    )
}