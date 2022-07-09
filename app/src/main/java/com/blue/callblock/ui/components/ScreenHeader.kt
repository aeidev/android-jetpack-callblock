package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ScreenHeader(titleLabel: String, subTitleLabel: String? = null) {
    Text(
        text = titleLabel,
        modifier = Modifier.padding(
            start = 0.dp,
            top = 32.dp,
            end = 12.dp,
            bottom = 6.dp
        ),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
    if (subTitleLabel != null) {
        Text(
            modifier = Modifier.padding(
                start = 0.dp,
                top = 0.dp,
                end = 12.dp,
                bottom = 12.dp
            ), text = subTitleLabel
        )
    }
}