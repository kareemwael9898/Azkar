package com.kareem.azkar;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AzkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;  // RecyclerView to display the list of Azkar (remembrances)
    ArrayList<ZekrDM> Azkar;    // ArrayList to store the data of Azkar
    AzkarAdapter azkarAdapter;  // Adapter to connect between the data and the RecyclerView

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("AzkarActivity", "onCreate");
        setContentView(R.layout.activity_azkar);

        // Get the type of Azkar from the intent that started this activity
        String type = getIntent().getStringExtra("type");
        Log.e("AzkarActivity", "Intent " + type);

        // Initialize the ArrayList and add data to it based on the type
        Azkar = new ArrayList<>();
        Azkar.addAll(ZekrDM.getData(type));

        // Initialize the RecyclerView and set its adapter
        recyclerView = findViewById(R.id.rv_masaa);
        azkarAdapter = new AzkarAdapter(this, Azkar);
        recyclerView.setAdapter(azkarAdapter);
    }
}