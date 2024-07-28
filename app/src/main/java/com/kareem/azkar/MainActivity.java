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

    public void sabahClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        intent.putExtra("type", "sabah");
        startActivity(intent);
    }

    public void masaaClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        intent.putExtra("type", "masaa");
        startActivity(intent);
    }

    public void prayClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AzkarActivity.class);
        intent.putExtra("type", "pray");
        startActivity(intent);
    }

    public void tasbeehClicked(View view) {
        Intent intent = new Intent(MainActivity.this, TasbeehActivity.class);
        intent.putExtra("type", "tasbeeh");
        startActivity(intent);
    }
}
