package com.example.myapplication;

import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class Notifications extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        // Get notification details
        String pack = sbn.getPackageName();
        String ticker = "";
        if (sbn.getNotification().tickerText != null) {
            ticker = sbn.getNotification().tickerText.toString();
        }
        Bundle extras = sbn.getNotification().extras;
        String title = extras.getString("android.title");
        String text = extras.getCharSequence("android.text").toString();

        // Store notification data in a string or database
        String notificationData = "Package: " + pack + "\nTitle: " + title + "\nText: " + text;

        // Handle the stored data as needed
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Handle removed notifications if needed
    }
}