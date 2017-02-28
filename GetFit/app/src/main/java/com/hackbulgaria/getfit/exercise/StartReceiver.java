package com.hackbulgaria.getfit.exercise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;



public class StartReceiver extends BroadcastReceiver {
    Notifications notifications = new Notifications();
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED))
        {
            notifications.setNotification(context);
        }
    }
}
