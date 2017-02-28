package com.hackbulgaria.getfit.workout.muscleGain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hackbulgaria.getfit.MainActivity;
import com.hackbulgaria.getfit.R;

public class MuscleGainHome_Pushups extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_gain_home__pushups);


        Button backMainButton;
        backMainButton = (Button) findViewById(R.id.backMainButton);

        backMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MuscleGainHome_Pushups.this, MainActivity.class));
            }
        });


    }
}
