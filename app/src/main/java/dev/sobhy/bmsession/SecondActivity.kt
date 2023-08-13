package dev.sobhy.bmsession

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.app.NotificationCompat
import dev.sobhy.bmsession.ui.theme.BMSessionTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMSessionTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    val receiveText = intent.getStringExtra("textvalue")

                    Text(text = "$receiveText")
                    Button(onClick = {
                        showNotification(receiveText!!)
                    }) {
                        Text(text = "Show Notification")
                    }
                }

            }
        }
    }

    private fun showNotification(text: String) {
        val channelId = "ChannelId"
        val channel =
            NotificationChannel(channelId, "ChannelName", NotificationManager.IMPORTANCE_DEFAULT)
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
        val notificationBuilder =
            NotificationCompat.Builder(this, channelId)
                .setContentTitle("Title")
                .setContentText(text)
                .setSmallIcon(android.R.drawable.alert_dark_frame)
        notificationManager.notify(1, notificationBuilder.build())
    }
}

