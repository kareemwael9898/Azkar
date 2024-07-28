package com.kareem.azkar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TasbeehActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView textView;
    Button increaseButton, resetButton;
    int counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TasbeehActivity", "onCreate");
        setContentView(R.layout.activity_tasbeeh);

        mediaPlayer = MediaPlayer.create(TasbeehActivity.this, R.raw.click);
        textView = findViewById(R.id.counter_value_tv);
        increaseButton = findViewById(R.id.increase_btn);
        resetButton = findViewById(R.id.reset_btn);

        increaseButton.setOnClickListener(view -> {
            Log.e("increaseButton", "Clicked");
            counter += 1;
            Log.e("increaseButton", "counter = " + counter);
            if (counter % 33 == 0 && counter != 0) {
                mediaPlayer.start();
            }
            updateTextView();
        });
        resetButton.setOnClickListener(view -> {
            Log.e("resetButton", "Clicked");
            counter = 0;
            textView.setText("!!!0");
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

    private void updateTextView() {
        if (counter < 10) {
            textView.setText("!!!" + counter);
        } else if (counter < 100) {
            textView.setText("!!" + counter);
        } else if (counter < 1000) {
            textView.setText("!" + counter);
        } else if (counter < 10000) {
            textView.setText("" + counter);
        } else {
            counter = 0;
            textView.setText("!!!" + counter);
        }
    }
}
