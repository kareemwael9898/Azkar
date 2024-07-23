package com.kareem.azkar;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MasaaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ZekrDM> Azkar;
    AzkarAdapter azkarAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masaa_activity);
        Log.e("MasaaActivity", "onCreate");

        Azkar = new ArrayList<>();
        fillData();

        recyclerView = findViewById(R.id.rv_masaa);

        azkarAdapter = new AzkarAdapter(this, Azkar);
        recyclerView.setAdapter(azkarAdapter);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
    /*
        // Get All Resources
        Context context = getApplicationContext();
        Resources res = context.getResources();
        for (Field field : R.string.class.getFields()) {
            try {
                String stringName = field.getName();
                int stringId = field.getInt(null);
                String stringValue = res.getString(stringId);
              Log.e("String Resource", "Id: " + stringId + ", Field: " + field);

                TextView txt = new TextView(this, null, 0, R.style.MyTextViewStyle);
                txt.setText(stringValue);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    */
        Log.e("TAG", "Done");
//        Log.e("TAG", ""+ R.string.app_name);
//        Log.e("TAG", ""+ R.string.aya1);
    }

    public void counter( View view){
        Log.e("counter", "clicked");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Log.e("wait", "yes");
//                if (view.get){
//                }
                TextView txt = (TextView) view;
                txt.setVisibility(View.GONE);

            }
        }, 600);
    }

    private void fillData(){
        Azkar.addAll(Arrays.asList(
                new ZekrDM(R.string.aya1,1),
                new ZekrDM(R.string.aya2,3),
                new ZekrDM(R.string.aya3,3),
                new ZekrDM(R.string.aya4,3),
                new ZekrDM(R.string.aya5m,1),
                new ZekrDM(R.string.doaa1m,1),
                new ZekrDM(R.string.doaa2m,1),
                new ZekrDM(R.string.doaa3,1),
                new ZekrDM(R.string.doaa4m,4),
                new ZekrDM(R.string.doaa5m,1),
                new ZekrDM(R.string.doaa6,3),
                new ZekrDM(R.string.doaa7,7),
                new ZekrDM(R.string.doaa8,1),
                new ZekrDM(R.string.doaa9,1),
                new ZekrDM(R.string.doaa10,3),
                new ZekrDM(R.string.doaa11,3),
                new ZekrDM(R.string.doaa12,3),
                new ZekrDM(R.string.doaa13m,1),
                new ZekrDM(R.string.doaa14m,1),
                new ZekrDM(R.string.doaa15,1),
                new ZekrDM(R.string.doaa16m,3),
                new ZekrDM(R.string.doaa17m,3),
                new ZekrDM(R.string.doaa18,10)
        ));

    }

}