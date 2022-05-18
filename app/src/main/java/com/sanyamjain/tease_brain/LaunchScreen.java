package com.sanyamjain.tease_brain;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class LaunchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        fireSplash();
    }

    private void fireSplash() {
        int splash_screen_time_out = 4500;
        new Handler().postDelayed(() -> {
            Intent i = new Intent(LaunchScreen.this, HomePage.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, splash_screen_time_out);
    }
}