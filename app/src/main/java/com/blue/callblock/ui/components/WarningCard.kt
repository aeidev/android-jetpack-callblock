package com.blue.callblock.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.blue.callblock.ui.theme.warningBackground

@Composable
fun WarningCard(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(Dp.Unspecified, 34.dp)
            .background(color = MaterialTheme.colors.warningBackground)
            .padding(12.dp, 12.dp)
    ) {
        content()
    }
}