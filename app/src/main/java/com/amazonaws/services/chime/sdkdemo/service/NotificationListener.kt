package com.amazonaws.services.chime.sdkdemo.service

import android.content.ComponentName
import android.provider.Settings
import android.service.notification.NotificationListenerService
import android.util.Log


class NotificationListener : NotificationListenerService() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.d("1234", "NOTIFICATION LISTENER CONNECTED!!!")
    }

    /*
        @Override
        public void onNotificationPosted (StatusBarNotification sbn) {
            if(sbn != null && sbn.getNotification() != null) {
                Log.i("notifcation", sbn.getNotification().toString());
                String title = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TITLE).toString();
                String text = sbn.getNotification().extras.getCharSequence(Notification.EXTRA_TEXT).toString();
                Log.i("notifcation", "title: " + title + " text: " + text);

                // Qui il vostro codice
            }
        }
        @Override
        public void onNotificationRemoved (StatusBarNotification sbn) {
            Log.i("notifcation", "onNotificationRemoved");
        }
        */
    fun VerifyNotificationPermission(): Boolean {
        val theList = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
        val theListList = theList.split(":").toTypedArray()
        val me = ComponentName(this, NotificationListener::class.java).flattenToString()
        for (next in theListList) {
            if (me == next) return true
        }
        return false
    }
}