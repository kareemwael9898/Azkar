package com.kareem.azkar;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AzkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ZekrDM> Azkar;
    AzkarAdapter azkarAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("AzkarActivity", "onCreate");
        setContentView(R.layout.activity_azkar);

        String type = getIntent().getStringExtra("type");
        Log.e("AzkarActivity", "Intent " + type);
        Azkar = new ArrayList<>();
        Azkar.addAll(ZekrDM.getData(type));

        recyclerView = findViewById(R.id.rv_masaa);
        azkarAdapter = new AzkarAdapter(this, Azkar);
        recyclerView.setAdapter(azkarAdapter);
    }
}