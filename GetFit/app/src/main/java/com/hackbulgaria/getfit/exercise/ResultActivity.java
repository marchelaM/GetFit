package com.hackbulgaria.getfit.exercise;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackbulgaria.getfit.R;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        final TextView textView = (TextView) findViewById(R.id.textView);
        final EditText editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        final SharedPreferences savedData = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        final String results;

        final int type = getIntent().getExtras().getInt("type");

        switch (type) {
            case 0:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.situps));
                results = savedData.getString("resultsSitups", "");
                break;
            case 1:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.pushups));
                results = savedData.getString("resultsPushups", "");
                break;
            default:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.running));
                results = savedData.getString("resultsRuns", "");
                break;
        }

        final String [] resultsData = results.split(";");

        String data = "";
        for (int i = 0; i < resultsData.length; i++) {
            if (data.equals("")) data += resultsData[i];
            else data += ", " + resultsData[i];
        }

        textView.setText(data);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = editText.getText().toString();
                String newResults;

                if (results.equals("")) newResults = results + data;
                else newResults = results + "; " + data;

                switch(type) {
                    case 0:
                        savedData.edit().putString("resultsSitups", newResults).commit();
                        break;
                    case 1:
                        savedData.edit().putString("resultsPushups", newResults).commit();
                        break;
                    case 2:
                        savedData.edit().putString("resultsRuns", newResults).commit();
                        break;
                }


                textView.setText(newResults);
            }
        });
    }


}
