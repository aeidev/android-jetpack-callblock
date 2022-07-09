package com.blue.callblock

import android.util.Log

object AppLogger {
    fun logD(TAG: String, message: String) {
        if (Constants.LOGGING_ENABLED) {
            Log.d(Constants.APP_LOG_TAG + TAG, message)
        }
    }

    fun logV(TAG: String, message: String) {
        if (Constants.LOGGING_ENABLED) {
            Log.v(Constants.APP_LOG_TAG + TAG, message)
        }
    }

    fun logE(TAG: String, e: Exception, message: String? = null) {
        if (Constants.LOGGING_ENABLED) {
            Log.e(Constants.APP_LOG_TAG + TAG, message, e)
        }
    }

    fun logAlways(TAG: String, message: String) {
        Log.v(Constants.APP_LOG_TAG + TAG, message)
    }
}