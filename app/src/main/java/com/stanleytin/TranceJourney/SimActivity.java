package com.stanleytin.TranceJourney;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SimActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new DrawView(this));
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onPause(){
        super.onPause();
    }

    protected void onRestart() {
        super.onRestart();
    }

}
