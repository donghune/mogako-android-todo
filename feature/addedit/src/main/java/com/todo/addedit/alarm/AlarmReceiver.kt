package com.todo.addedit.alarm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build.*
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.namu.common.entity.Todo
import com.todo.addedit.R


class AlarmReceiver : BroadcastReceiver() {

    companion object {
        private const val TAG = "AlarmReceiver"

        private const val NOTIFICATION_ID = 0

        private const val CHANNEL_ID = "CHANNEL_ID"
        private const val CHANNEL_NAME = "CHANNEL_NAME"

        private const val EXTRA_TODO_CONTENT = "EXTRA_TODO_CONTENT"

        fun getPendingIntent(context: Context, todo: Todo): PendingIntent? {
            return PendingIntent.getBroadcast(
                context,
                0,
                Intent(context, AlarmReceiver::class.java).apply {
                    putExtra(EXTRA_TODO_CONTENT, todo.content)
                },
                0
            )
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        val todoContent = intent.getStringExtra(EXTRA_TODO_CONTENT) ?: return

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification: Notification = if (VERSION.SDK_INT >= VERSION_CODES.O) {
            createNotificationChannel(manager)
            Notification.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("알림")
                .setContentText(todoContent)
                .setVisibility(Notification.VISIBILITY_PRIVATE)
                .setChannelId(CHANNEL_ID)
                .setShowWhen(false)
                .build()
        } else {
            NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("알림")
                .setContentText(todoContent)
                .setAutoCancel(true)
                .build()
        }
        manager.notify(NOTIFICATION_ID, notification)

    }

    @RequiresApi(VERSION_CODES.O)
    private fun createNotificationChannel(manager: NotificationManager) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = ""
        channel.setShowBadge(false)
        manager.createNotificationChannel(channel)
    }

}