package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blue.callblock.repository.CallEvent

@Composable
fun RecentCallList(calls: List<CallEvent>, onItemClick: (phoneNumber: String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp, 4.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Latest call activity", fontSize = 12.sp)
            if (calls.isNotEmpty()) {
                Row( verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "See more", fontSize = 12.sp)
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "see more action",
                        modifier = Modifier
                            .padding(start = 0.dp, bottom = 0.dp, end = 0.dp, top = 2.dp)
                            .height(16.dp)
                            .width(16.dp)
                    )
                }

            }
        }
        if (calls.isEmpty()) {
            Text(
                text = "Your last 3 calls will display here.",
                fontSize = 11.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(0.dp, 32.dp)
            )
        } else {
            LazyColumn {
                items(calls) { call ->
                    CallListItem(call = call, onClick = onItemClick)
                }
            }
        }
    }

}