package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blue.callblock.helpers.DateHelper
import com.blue.callblock.repository.CallEvent

@Composable
fun CallListItem(call: CallEvent, onClick: (phoneNumber: String) -> Unit) {
    val timeDisplay = if (DateHelper.isTimeInMilliToday(call.timeStamp)) {
        DateHelper.millisecondsToTime(call.timeStamp)
    } else {
        DateHelper.millisecondsToDate(call.timeStamp)
    }
    ClickableCardBase(onClick = { onClick(call.phoneNumber)}, content = {
            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "call avatar",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(4.dp)
                        .height(28.dp)
                        .width(28.dp)
                )
                Text(
                    text = "Call " + call.callType.name.lowercase(),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 0.dp, top = 0.dp, end = 6.dp, bottom = 0.dp)
                )
                Text(text = timeDisplay, modifier = Modifier.align(Alignment.CenterVertically))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp, 2.dp)
            ) {
                Text(text = call.phoneNumber, fontSize = 18.sp)
            }
        })
}