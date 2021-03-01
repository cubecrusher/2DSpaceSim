package com.stanleytin.TranceJourney;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class DrawView extends SurfaceView implements SurfaceHolder.Callback {
    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    private DrawThread drawThread;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawThread = new DrawThread(getContext(),getHolder());
        drawThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawThread.requestStop();
        boolean retry = true;
        while (retry) {
            try {
                drawThread.join();
                retry = false;
            } catch (InterruptedException e) {
                System.out.println("Something happened.");
            }
        }
    }
}
