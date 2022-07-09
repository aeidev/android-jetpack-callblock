package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ListActionCard(titleLabel: String, subTitleLabel: String, onClick: () -> Unit) {
    ClickableCardBase(onClick = onClick) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = titleLabel, fontWeight = FontWeight.Bold)
            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = "action icon")
        }
        Row(modifier = Modifier.padding(0.dp, 4.dp)) {
            Text(text = subTitleLabel)
        }
    }
}