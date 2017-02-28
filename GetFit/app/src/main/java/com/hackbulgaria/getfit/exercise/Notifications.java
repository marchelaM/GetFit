package com.hackbulgaria.getfit.exercise;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

import com.hackbulgaria.getfit.R;

import java.util.List;
import java.util.Random;



public class Notifications extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        int counter = settings.getInt("counter", 0);

        List<String> exercises = Exercise.getExercises();

        if (counter >= exercises.size()) counter = 0;

        
        Toast.makeText(context, exercises.get(counter), Toast.LENGTH_LONG).show(); 

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.man)
                        .setContentTitle("GetFit")
                        .setContentText(exercises.get(counter));

        Intent resultIntent = new Intent(context, ResultActivity.class);
        resultIntent.putExtra("type", counter);

        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(new Random().nextInt(1000), mBuilder.build());


        settings.edit().putInt("counter", ++counter).commit();

        wl.release();
    }

    public void setNotification(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, Notifications.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 10000, pi); // Millisec * Second * Minute
    }

    public void cancelNotification(Context context)
    {
        Intent intent = new Intent(context, Notifications.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }
}
