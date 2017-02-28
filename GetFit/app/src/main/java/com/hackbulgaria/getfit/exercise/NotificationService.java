package com.hackbulgaria.getfit.exercise;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;


public class NotificationService extends Service {
    Notifications notifications = new Notifications();
    public void onCreate()
    {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        notifications.setNotification(this);
        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId)
    {
        notifications.setNotification(this);
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
