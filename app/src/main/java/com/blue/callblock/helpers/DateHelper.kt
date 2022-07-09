package com.blue.callblock.helpers

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

object DateHelper {
    const val ONE_DAY_IN_MILLISECONDS =  86400000
    fun millisecondsToDate(timeInMilli: Long): String {
        val date = Date(timeInMilli)
        return SimpleDateFormat.getDateInstance(DateFormat.DEFAULT).format(date)
    }
    fun millisecondsToTime(timeInMilli: Long): String {
        val date = Date(timeInMilli)
        return SimpleDateFormat.getTimeInstance(DateFormat.SHORT).format(date)
    }

    /**
     * Compares a time in milliseconds to the current time in milliseconds.
     * If the difference between the two is greater than 1 day in milliseconds
     * then return true
     */
    fun isTimeInMilliToday(timeInMilli: Long): Boolean {
        return abs(System.currentTimeMillis() - timeInMilli) <= ONE_DAY_IN_MILLISECONDS
    }
}