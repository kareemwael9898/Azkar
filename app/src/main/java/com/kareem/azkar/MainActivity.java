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
        setContentView(R.layout.main_activity);
    }

    public void sabahClicked(View view) {
        Intent intent = new Intent(MainActivity.this,SabahActivity.class);
        startActivity(intent);
    }
    public void masaaClicked(View view){
        Intent intent = new Intent(MainActivity.this, MasaaActivity.class);
        startActivity(intent);
    }
}
