package com.blue.callblock.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.blue.callblock.ui.theme.cardBackground


@Composable
fun ClickableCardBase(onClick: () -> Unit, content: @Composable () -> Unit) {
        Card(shape = RoundedCornerShape(10.dp), elevation = 0.dp,) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 4.dp)
                    .clickable(onClick = onClick)
                    .background(color = MaterialTheme.colors.cardBackground)
                    .padding(8.dp, 12.dp)
            ) {
                content()
            }
        }
}