package com.hackbulgaria.getfit.workout.muscleGain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hackbulgaria.getfit.R;

public class WorkoutProgram extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_program);

        Button muscleGain = (Button) findViewById(R.id.muscleGain);
        Button weightLossButton = (Button) findViewById(R.id.weightLoss);
        Button endurance = (Button) findViewById(R.id.endurance);

        muscleGain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkoutProgram.this, MuscleGainTrainingEnvironment.class));
            }
        });

        weightLossButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkoutProgram.this, MuscleGainTrainingEnvironment.class));
            }
        });

        endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WorkoutProgram.this, MuscleGainTrainingEnvironment.class));
            }
        });
    }
}
