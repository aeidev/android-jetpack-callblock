package com.blue.callblock.helpers

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    fun millisecondsToDate(timeInMilli: Long): String {
        val date = Date()
        date.time = timeInMilli
        return SimpleDateFormat.getDateInstance(DateFormat.DEFAULT).format(date)
    }
    fun millisecondsToTime(timeInMilli: Long): String {
        val date = Date()
        date.time = timeInMilli
        return SimpleDateFormat.getTimeInstance(DateFormat.SHORT).format(date)
    }
}