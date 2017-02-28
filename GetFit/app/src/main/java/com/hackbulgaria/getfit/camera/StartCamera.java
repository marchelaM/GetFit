package com.hackbulgaria.getfit.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hackbulgaria.getfit.MainActivity;
import com.hackbulgaria.getfit.R;

public class StartCamera extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView personImage;

    Button cameraButton;
    Button quitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_camera);

        cameraButton = (Button) findViewById(R.id.cameraButton);

        personImage = (ImageView) findViewById(R.id.personImage);

        quitButton = (Button) findViewById(R.id.quitButton);


        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartCamera.this, MainActivity.class));
            }
        });


    }

    public void launchCamera(View view) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            // Get Photo
            Bundle extras = data.getExtras();

            Bitmap photo = (Bitmap) extras.get("data");

            personImage.setImageBitmap(photo);


        }


    }


}












