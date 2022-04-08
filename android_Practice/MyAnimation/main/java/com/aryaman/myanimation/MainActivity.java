 //add images to drawable
//create new drawable resourse file
//create a raw dir in res folder

package com.aryaman.myanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image1);
        mp = new MediaPlayer().create(MainActivity.this, R.raw.mariosong);
        imageView.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable) imageView.getBackground()).start();
                mp.start();
            }
        });
    }

  public void onBackPressed() {

        super.onBackPressed();
        mp.stop();
    }
}