package com.example.fancyviews;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;

public class FancyProgressBar extends ProgressBar {

    private int[] colorSequence = {
            0xFFE91E63, // ורוד
            0xFF3F51B5, // כחול
            0xFF4CAF50, // ירוק
            0xFFFF9800  // כתום
    };

    private int currentColorIndex = 0;
    private Handler handler = new Handler();
    private boolean isRunning = false;
    private long colorChangeInterval = 700; // מילישניות

    public FancyProgressBar(Context context) {
        super(context);
        init();
    }

    public FancyProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FancyProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setIndeterminate(true);
        startColorCycle();
    }

    private void startColorCycle() {
        isRunning = true;
        handler.postDelayed(colorChanger, colorChangeInterval);
    }

    private final Runnable colorChanger = new Runnable() {
        @Override
        public void run() {
            if (!isRunning) return;

            getIndeterminateDrawable().setColorFilter(colorSequence[currentColorIndex], PorterDuff.Mode.SRC_IN);
            currentColorIndex = (currentColorIndex + 1) % colorSequence.length;

            handler.postDelayed(this, colorChangeInterval);
        }
    };

    public void stopColorCycle() {
        isRunning = false;
        handler.removeCallbacks(colorChanger);
    }

    public void setColorSequence(int[] colors) {
        this.colorSequence = colors;
        currentColorIndex = 0;
    }

    public void setColorChangeInterval(long intervalMillis) {
        this.colorChangeInterval = intervalMillis;
    }
    public void restartColorCycle() {
        stopColorCycle();
        currentColorIndex = 0;
        startColorCycle();
    }

}
