package com.blue.callblock.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blue.callblock.repository.CallEvent
import com.blue.callblock.ui.theme.cardBackground

@Composable
fun CallListItem(call: CallEvent, onClick: (phoneNumber: String) -> Unit) {
        ClickableCardBase(onClick = { onClick(call.phoneNumber)}, content = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "call avatar",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(4.dp)
                        .height(32.dp)
                        .width(32.dp)
                )
                Text(
                    text = call.callType.name,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 0.dp, top = 0.dp, end = 6.dp, bottom = 0.dp)
                )
                Text(text = "5 minutes ago", modifier = Modifier.align(Alignment.CenterVertically))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 6.dp)
            ) {
                Text(text = call.phoneNumber, fontSize = 18.sp)
            }
        })
}