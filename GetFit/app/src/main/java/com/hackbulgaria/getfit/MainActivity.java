package com.hackbulgaria.getfit;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hackbulgaria.getfit.camera.StartCamera;
import com.hackbulgaria.getfit.exercise.NotificationService;
import com.hackbulgaria.getfit.exercise.Notifications;
import com.hackbulgaria.getfit.workout.muscleGain.WorkoutProgram;
import com.hackbulgaria.getfit.foodTest.StartTest;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button mStartButton;
    Button mStartCameraButton;
    Button mQuitButton;
    Button workout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workout = (Button) findViewById(R.id.workoutProgram);
        mStartButton = (Button) findViewById(R.id.getHealthPlanButton);
        mStartCameraButton = (Button) findViewById(R.id.startCameraActivityButton);
        mQuitButton = (Button) findViewById(R.id.quitButton);

        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WorkoutProgram.class));
            }
        });


        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StartTest.class));
            }
        });


        mStartCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StartCamera.class));
            }
        });


        mQuitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appQuit();
            }
        });


        Intent myIntent = new Intent(MainActivity.this, NotificationService.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getService(MainActivity.this, 0, myIntent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 28);
        calendar.set(Calendar.SECOND, 10);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);  //set repeating every 24 hours

        Notifications notifications = new Notifications();
        notifications.setNotification(getApplicationContext());
    }


    public void appQuit() {

        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


}
