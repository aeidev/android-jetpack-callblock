package com.blue.callblock.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blue.callblock.repository.CallEvent

@Composable
fun RecentCallList(calls: List<CallEvent>, onItemClick: (phoneNumber: String) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 4.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Latest call activity", fontSize = 12.sp)
            if (calls.isNotEmpty()) Text(text = "See more", fontSize = 12.sp)
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