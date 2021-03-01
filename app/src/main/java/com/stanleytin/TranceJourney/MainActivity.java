package com.stanleytin.TranceJourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public Button start;
    public EditText planets, p1xvel, p1yvel, p1xpos, p1ypos, p2xvel, p2yvel, p2xpos, p2ypos, p3xvel, p3yvel, p3xpos, p3ypos, sunmass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        planets = findViewById(R.id.planets);
        p1xvel = findViewById(R.id.p1xvel);
        p1yvel = findViewById(R.id.p1yvel);
        p2xvel = findViewById(R.id.p2xvel);
        p2yvel = findViewById(R.id.p2yvel);
        p3xvel = findViewById(R.id.p3xvel);
        p3yvel = findViewById(R.id.p3yvel);
        p1xpos = findViewById(R.id.p1xloc);
        p1ypos = findViewById(R.id.p1yloc);
        p2xpos = findViewById(R.id.p2xloc);
        p2ypos = findViewById(R.id.p2yloc);
        p3xpos = findViewById(R.id.p3xloc);
        p3ypos = findViewById(R.id.p3yloc);
        sunmass = findViewById(R.id.sunmass);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SimActivity.class));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Integer planetamt = Integer.parseInt(planets.getText().toString());
        Integer starmass = Integer.parseInt(sunmass.getText().toString());
        Float pl1xvel = Float.parseFloat(p1xvel.getText().toString());
        Float pl1yvel = Float.parseFloat(p1yvel.getText().toString());
        Float pl1xpos = Float.parseFloat(p1xpos.getText().toString());
        Float pl1ypos = Float.parseFloat(p1ypos.getText().toString());
        Float pl2xvel = Float.parseFloat(p2xvel.getText().toString());
        Float pl2yvel = Float.parseFloat(p2yvel.getText().toString());
        Float pl2xpos = Float.parseFloat(p2xpos.getText().toString());
        Float pl2ypos = Float.parseFloat(p2ypos.getText().toString());
        Float pl3xvel = Float.parseFloat(p3xvel.getText().toString());
        Float pl3yvel = Float.parseFloat(p3yvel.getText().toString());
        Float pl3xpos = Float.parseFloat(p3xpos.getText().toString());
        Float pl3ypos = Float.parseFloat(p3ypos.getText().toString());
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
