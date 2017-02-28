package com.hackbulgaria.getfit.foodTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hackbulgaria.getfit.MainActivity;
import com.hackbulgaria.getfit.R;

public class EndTest extends AppCompatActivity {

    Button backToMain;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_test);


        backToMain = (Button) findViewById(R.id.backToMain);
        saveButton = (Button) findViewById(R.id.saveButton);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndTest.this, MainActivity.class));
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EndTest.this, "Saved To Documents", Toast.LENGTH_LONG).show();
            }
        });


    }
}
