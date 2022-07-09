package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CheckBoxCard(label: String, initialValue: Boolean, onClick: (state: Boolean) -> Unit) {
    val checkedState = remember { mutableStateOf(initialValue) }
    ClickableCardBase(onClick = {
        val newState = !checkedState.value
        checkedState.value = newState
        onClick(newState)
    }) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(label)
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                    onClick(it)
                }
            )
        }

    }
}