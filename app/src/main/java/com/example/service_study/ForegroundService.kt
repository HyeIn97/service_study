package com.example.service_study

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {
    private val SERVICE_ID = 1001
    private val CHANNEL_ID = "CHANNEL_STUDY"

    private var notificationManager: NotificationManager? = null
    private var notificationBuilder: Notification? = null

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotification()

        return START_STICKY
    }

    private fun createNotification() {
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager?.createNotificationChannel(NotificationChannel(CHANNEL_ID, "CHANNEL_NAME", NotificationManager.IMPORTANCE_NONE))
        notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Service Study Notification")
            .setContentText("~ Notification Content ~")
            .build()

        startForeground(SERVICE_ID, notificationBuilder)
    }
}