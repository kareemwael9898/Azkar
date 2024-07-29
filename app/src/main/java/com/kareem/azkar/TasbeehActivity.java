package com.kareem.azkar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TasbeehActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;            // To play sound effects
    TextView textView;                  // To display the counter value
    Button increaseButton, resetButton; // Buttons for increasing and resetting the counter
    int counter = 0;                    // Counter to store the tasbeeh count

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("TasbeehActivity", "onCreate");
        setContentView(R.layout.activity_tasbeeh);

        // Initialize MediaPlayer with the click sound
        mediaPlayer = MediaPlayer.create(TasbeehActivity.this, R.raw.click);
        // Find views by their IDs
        textView = findViewById(R.id.counter_value_tv);
        increaseButton = findViewById(R.id.increase_btn);
        resetButton = findViewById(R.id.reset_btn);

        // Handle click event for increase button
        increaseButton.setOnClickListener(view -> {
            counter += 1;
            Log.e("increaseButton", "counter = " + counter);
            if (counter % 33 == 0 && counter != 0) {
                mediaPlayer.start();    // Play sound effect every 33 counts
            }
            updateTextView();   // Format the text as DSEG font documntation
        });
        // Handle click event for reset button
        resetButton.setOnClickListener(view -> {
            Log.e("resetButton", "Clicked");
            counter = 0;
            textView.setText("!!!0");   // "!!!" indicates 3 empty digit spaces according to the DSEG font
        });
    }

    @Override
    protected void onDestroy() {
        mediaPlayer.release();
        super.onDestroy();
    }

    // Method to update and format the TextView based on the counter value
    private void updateTextView() {
        if (counter < 10) {
            textView.setText("!!!" + counter);  // "!" equals to empty digit space in DSEG font
        } else if (counter < 100) {
            textView.setText("!!" + counter);
        } else if (counter < 1000) {
            textView.setText("!" + counter);
        } else if (counter < 10000) {
            textView.setText("" + counter); // No prefix needed for four-digit numbers
        } else {
            counter = 0;    // Reset counter if it exceeds 9999
            textView.setText("!!!" + counter);
        }
    }
}
