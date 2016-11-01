package com.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.alexsandercaproni.unlock4forgotten.LoginActivity;
import com.example.alexsandercaproni.unlock4forgotten.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //ActionBar actionBar = getActionBar();
        //actionBar.hide();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent intent = new Intent();
                intent.setClass(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 6000);
    }
}
