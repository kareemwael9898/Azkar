package com.kareem.azkar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Handle click events for the main page buttons
    public void eveningClicked(View view) {
        // Create an intent to start AzkarActivity
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        // Add an extra to the intent to specify the type of Azkar
        intent.putExtra("type", "evening");
        startActivity(intent);
    }

    public void morningClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        intent.putExtra("type", "morning");
        startActivity(intent);
    }

    public void prayClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        intent.putExtra("type", "pray");
        startActivity(intent);
    }

    public void tasbeehClicked(View view) {
        Intent intent = new Intent(MainActivity.this, TasbeehActivity.class);
        startActivity(intent);
    }
}
