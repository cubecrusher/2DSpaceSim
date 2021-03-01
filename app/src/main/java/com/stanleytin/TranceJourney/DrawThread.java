package com.stanleytin.TranceJourney;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;

public class DrawThread extends Thread implements View.OnClickListener {

    private SurfaceHolder surfaceHolder;
    private volatile boolean running = true;
    private final Paint backgroundPaint = new Paint();
    private final Paint sunPaint = new Paint();
    private final Paint planet1Paint = new Paint();
    private final Paint textPaint = new Paint();
    private final Paint alertTextPaint = new Paint();
    private final Paint star1Paint = new Paint();
    private final Paint star2Paint = new Paint();
    private final Paint star3Paint = new Paint();

    {
        backgroundPaint.setColor(Color.rgb(0,0,22));
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setAntiAlias(true);
        sunPaint.setColor(Color.YELLOW);
        sunPaint.setStyle(Paint.Style.FILL);
        sunPaint.setAntiAlias(true);
        planet1Paint.setColor(Color.LTGRAY);
        planet1Paint.setStyle(Paint.Style.FILL);
        planet1Paint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setAntiAlias(true);
        alertTextPaint.setColor(Color.RED);
        alertTextPaint.setTextSize(60);
        alertTextPaint.setAntiAlias(true);
        star1Paint.setColor(Color.argb(128,255,255,255));
        star1Paint.setStrokeWidth(5);
        star1Paint.setAntiAlias(true);
        star2Paint.setColor(Color.argb(128,255,0,0));
        star2Paint.setStrokeWidth(5);
        star2Paint.setAntiAlias(true);
        star3Paint.setColor(Color.argb(128,255,255,0));
        star3Paint.setStrokeWidth(5);
        star3Paint.setAntiAlias(true);
    }

    public DrawThread(Context context, SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void requestStop() {
        running = false;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void run() {
        Canvas canvas = new Canvas();

        // Done: Make those variables customizable through EditTexts
        // Todo: Share variables from MainActivity with this class
        // Todo: Use arrays for different planets' variables (PlanetPos, PlanetMass, PlanetVel, StarDistance)
        int planets = 1;
        int updates = 0;
        int starRadius = 25;
        int starMass = 50000;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float planet1posX = width + (float) 200.0;
        float planet1posY = height + (float) 200.0;
        float planet1velX = 1;
        float planet1velY = 3;
        int collision = 25;
        boolean Collision = false;
        float ax1[] = new float[500];
        float ay1[] = new float[500];
        float ax2[] = new float[500];
        float ay2[] = new float[500];
        float ax3[] = new float[500];
        float ay3[] = new float[500];
        for (int i=0; i<500; i++) {
            ax1[i]=(int)(Math.random()*5000);
            ay1[i]=(int)(Math.random()*5000);
            ax2[i]=(int)(Math.random()*5000);
            ay2[i]=(int)(Math.random()*5000);
            ax3[i]=(int)(Math.random()*5000);
            ay3[i]=(int)(Math.random()*5000);
        }

        while (running) {
            try {
                canvas = surfaceHolder.lockCanvas();
                int starX = canvas.getWidth() / 2; // Something happens here (fixed)
                int starY = canvas.getHeight() / 2;
                double starDistance1 = Math.sqrt(Math.pow(planet1posX - starX, 2) + Math.pow(planet1posY - starY, 2));
                double accel1X = starMass * (starX - planet1posX) / Math.pow(starDistance1, 3);
                double accel1Y = starMass * (starY - planet1posY) / Math.pow(starDistance1, 3);
                planet1velX += accel1X;
                planet1velY += accel1Y;
                planet1posX += planet1velX;
                planet1posY += planet1velY;


                if (canvas != null) {
                    try {
                        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), backgroundPaint);
                        for (int i = 0; i < 500; i++) {
                            canvas.drawCircle(ax1[i], ay1[i], 2, star1Paint);
                            canvas.drawCircle(ax2[i], ay2[i], 2, star2Paint);
                            canvas.drawCircle(ax3[i], ay3[i], 2, star3Paint);

                        }
                        canvas.drawCircle(starX, starY, starRadius, sunPaint);
                        canvas.drawCircle(planet1posX, planet1posY, 10, planet1Paint);
                        canvas.drawText("Solar System Simulation (25.02.2021) by superlagger", 20, 40, textPaint);
                        canvas.drawText("Star - Radius: " + starRadius + ";  Mass: " + starMass + ";  Position: " + starX + ", " + starY, 20, 100, textPaint);
                        canvas.drawText("Planet 1 - Position: " + Math.ceil(planet1posX) + ", " + Math.ceil(planet1posY) + ";  Velocity: " + Math.ceil(planet1velX) + ", " + Math.ceil(planet1velY), 20, 130, textPaint);
                        if (starDistance1 <= collision) Collision = true;
                        if (Collision) canvas.drawText("Collision!", 20, 220, alertTextPaint);
                    } finally {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        updates++;
                    }
                }
            } catch (Exception e){
                System.out.println("Something happened.");
            }
        }
    }
}