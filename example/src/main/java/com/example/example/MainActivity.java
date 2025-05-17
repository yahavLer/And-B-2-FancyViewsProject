package com.example.example;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fancyviews.LoadingButton;
import com.example.fancyviews.OnStateChangeListener;
import com.example.fancyviews.FancyProgressBar;

public class MainActivity extends AppCompatActivity {

    private LoadingButton loadingButton;
    private FancyProgressBar fancyProgressBar;
    private Button btnStartLoading;
    private Button btnShowSuccess;
    private Button btnShowError;
    private Button btnDisable;
    private Button btnReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews(); // שליפת רכיבים מה-XML
        setButtonView(); // הגדרת טקסטים, צבעים ואייקונים
        setListeners(); // הגדרת מאזינים לאירועים
        setButtonAction(); // הגדרת לחצנים לפעולות שונות

        // צבעי שינוי מתחלפים של פס הטעינה
        fancyProgressBar.setColorChangeInterval(500);
        fancyProgressBar.setColorSequence(new int[]{
                Color.RED,
                Color.MAGENTA,
                Color.BLUE,
                Color.CYAN
        });
    }

    private void findViews() {
        btnStartLoading = findViewById(R.id.btnStartLoading);
        btnShowSuccess = findViewById(R.id.btnShowSuccess);
        btnShowError = findViewById(R.id.btnShowError);
        btnDisable = findViewById(R.id.btnDisable);
        btnReset = findViewById(R.id.btnReset);
        loadingButton = findViewById(R.id.loadingButton);
        fancyProgressBar = findViewById(R.id.fancyProgressBar);
    }

    private void setButtonView() {
        loadingButton.setTextForState(LoadingButton.ButtonState.SUCCESS, "הפעולה הצליחה!");
        loadingButton.setTextForState(LoadingButton.ButtonState.ERROR, "שגיאה בפעולה");
        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.IDLE, Color.parseColor("#6200EE"));
        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.SUCCESS, Color.parseColor("#4CAF50"));
        loadingButton.setBackgroundColorForState(LoadingButton.ButtonState.ERROR, Color.parseColor("#F44336"));
        loadingButton.setTextColorForState(LoadingButton.ButtonState.SUCCESS, Color.WHITE);
        loadingButton.setTextColorForState(LoadingButton.ButtonState.ERROR, Color.WHITE);
    }

    private void setListeners() {
        loadingButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChanged(LoadingButton.ButtonState newState) {
                Toast.makeText(MainActivity.this, "מצב חדש: " + newState.name(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setButtonAction() {
        btnStartLoading.setOnClickListener(v -> {
            loadingButton.setState(LoadingButton.ButtonState.LOADING);
            fancyProgressBar.setState(FancyProgressBar.ProgressState.LOADING);
        });

        btnShowSuccess.setOnClickListener(v -> {
            loadingButton.setState(LoadingButton.ButtonState.SUCCESS);
            fancyProgressBar.setState(FancyProgressBar.ProgressState.SUCCESS);
        });

        btnShowError.setOnClickListener(v -> {
            loadingButton.setState(LoadingButton.ButtonState.ERROR);
            fancyProgressBar.setState(FancyProgressBar.ProgressState.ERROR);
        });

        btnDisable.setOnClickListener(v -> {
            loadingButton.setState(LoadingButton.ButtonState.DISABLED);
            fancyProgressBar.setState(FancyProgressBar.ProgressState.DISABLED);
        });

        btnReset.setOnClickListener(v -> {
            loadingButton.setState(LoadingButton.ButtonState.IDLE);
            fancyProgressBar.setState(FancyProgressBar.ProgressState.IDLE);
        });

    }
}
