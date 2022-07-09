package com.blue.callblock.helpers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.net.toUri
import com.blue.callblock.Constants
import com.blue.callblock.MainActivity
import com.blue.callblock.R

object NotificationHelper {

    private const val blocked_channel_id = "blocked_channel"
    const val tag_blocked = "notif_tag_blocked_caller"
    private const val allowed_channel_id = "allowed_channel"
    const val tag_allowed = "notif_tag_allowed_caller"
    private const val intent_id_caller_notif_base = 100

    /*
     * Triggers a notification for a blocked caller.
     */
    fun doBlockedNotification(context: Context, phoneNumber: String) {
        val pendingIntent = getPendingIntentForCall(context, phoneNumber)
        val builder = NotificationCompat.Builder(context, blocked_channel_id)
            .setContentTitle(context.getString(R.string.notification_blocked_title))
            .setContentText(phoneNumber)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        builder.priority = NotificationCompat.PRIORITY_MAX
        createNotificationChannel(
            context,
            blocked_channel_id,
            context.getString(R.string.channel_blocked_name),
            context.getString(R.string.channel_blocked_description),
            NotificationManager.IMPORTANCE_HIGH
        )
        with(NotificationManagerCompat.from(context)) {
            notify(tag_blocked, phoneNumber.hashCode(), builder.build())
        }
    }

    fun doAllowedNotification(context: Context, phoneNumber: String) {
        val pendingIntent = getPendingIntentForCall(context, phoneNumber)
        val builder = NotificationCompat.Builder(context, allowed_channel_id)
            .setContentTitle(context.getString(R.string.notification_allowed_title))
            .setContentText(phoneNumber)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
        builder.priority = NotificationCompat.PRIORITY_MAX
        createNotificationChannel(
            context,
            allowed_channel_id,
            context.getString(R.string.channel_allowed_name),
            context.getString(R.string.channel_allowed_description),
            NotificationManager.IMPORTANCE_HIGH
        )
        with(NotificationManagerCompat.from(context)) {
            notify(tag_allowed, phoneNumber.hashCode(), builder.build())
        }
    }

    private fun getPendingIntentForCall(context: Context, phoneNumber: String): PendingIntent? {
        val deepLinkIntent = Intent(
            Intent.ACTION_VIEW,
            "${Constants.APP_URI}$phoneNumber".toUri(),
            context,
            MainActivity::class.java
        )
        deepLinkIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val deepLinkPendingIntent: PendingIntent? = TaskStackBuilder.create(context).run {
            addNextIntentWithParentStack(deepLinkIntent)
            getPendingIntent(intent_id_caller_notif_base + phoneNumber.hashCode(), PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        }
        return deepLinkPendingIntent
    }

    private fun createNotificationChannel(
        context: Context,
        channelId: String,
        name: String,
        descriptionText: String,
        importance: Int
    ) {
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            getSystemService(context, NotificationManager::class.java) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

}