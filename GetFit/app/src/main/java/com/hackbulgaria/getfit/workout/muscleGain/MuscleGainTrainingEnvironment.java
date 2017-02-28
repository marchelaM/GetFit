package com.hackbulgaria.getfit.workout.muscleGain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hackbulgaria.getfit.R;

public class MuscleGainTrainingEnvironment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_gain_training_environment);

        Button home = (Button) findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MuscleGainTrainingEnvironment.this, MuscleGainHome_Pushups.class));
            }
        });

        Button gym = (Button) findViewById(R.id.gym);
        gym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MuscleGainTrainingEnvironment.this, MuscleGainGym.class));
            }
        });

        Button outside = (Button) findViewById(R.id.outside);
        outside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MuscleGainTrainingEnvironment.this, MuscleGainOutside.class));
            }
        });


    }
}
