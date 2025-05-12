package com.example.example;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fancyviews.LoadingButton;
import com.example.fancyviews.OnStateChangeListener;
import com.example.fancyviews.FancyProgressBar;


public class MainActivity extends AppCompatActivity {

    private LoadingButton loadingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // שליפת הכפתור מה-XML
        loadingButton = findViewById(R.id.loadingButton);

        // הגדרת טקסט ואייקון לכל מצב
        loadingButton.setTextForState(LoadingButton.ButtonState.SUCCESS, "הפעולה הצליחה!");
        loadingButton.setIconForState(LoadingButton.ButtonState.SUCCESS, R.drawable.ic_check); // לוודא שיש קובץ כזה ב־res/drawable

        loadingButton.setTextForState(LoadingButton.ButtonState.ERROR, "שגיאה בפעולה");
        loadingButton.setIconForState(LoadingButton.ButtonState.ERROR, R.drawable.ic_error); // גם כאן לוודא

        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.IDLE, Color.parseColor("#6200EE"));
        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.SUCCESS, Color.parseColor("#4CAF50"));
        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.ERROR, Color.parseColor("#F44336"));

        loadingButton.setTextColorForState(LoadingButton.ButtonState.SUCCESS, Color.WHITE);
        loadingButton.setTextColorForState(LoadingButton.ButtonState.ERROR, Color.WHITE);


        // הדמיה: מעבר ממצב טעינה להצלחה אחרי 2 שניות
        loadingButton.setState(LoadingButton.ButtonState.LOADING);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingButton.setState(LoadingButton.ButtonState.SUCCESS);
            }
        }, 2000);

        loadingButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChanged(LoadingButton.ButtonState newState) {
                Toast.makeText(MainActivity.this, "מצב חדש: " + newState.name(), Toast.LENGTH_SHORT).show();
            }
        });
        FancyProgressBar fancyProgressBar = findViewById(R.id.fancyProgressBar);

        // שינוי צבעים מתחלפים והמרווח ביניהם
        fancyProgressBar.setColorChangeInterval(500); // כל חצי שנייה

        fancyProgressBar.setColorSequence(new int[]{
                Color.RED,
                Color.MAGENTA,
                Color.BLUE,
                Color.CYAN
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                fancyProgressBar.stopColorCycle();
                Toast.makeText(MainActivity.this, "הטעינה הסתיימה", Toast.LENGTH_SHORT).show();
            }
        }, 5000); // 5000 מ״ש = 5 שניות
        // הפסקת מחזור הצבעים אחרי 5 שניות
    }
}
