package com.kareem.azkar;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class ZekrDM {
    private int text;   // Resource ID for the text
    private int count;  // Number of times to display the Zekr

    // Constructor to initialize text and count
    public ZekrDM(int text, int count) {
        this.text = text;
        this.count = count;
    }

    // Initialize Getters & Setters
    public int getTextId() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Method to get a list of ZekrDM objects (Azkar) based on the type
    static public List<ZekrDM> getData(String type) {
        switch (type) {
            case "evening":
                return Arrays.asList(
                        new ZekrDM(R.string.aya1, 1),
                        new ZekrDM(R.string.aya2, 3),
                        new ZekrDM(R.string.aya3, 3),
                        new ZekrDM(R.string.aya4, 3),
                        new ZekrDM(R.string.aya5m, 1),
                        new ZekrDM(R.string.doaa1m, 1),
                        new ZekrDM(R.string.doaa2m, 1),
                        new ZekrDM(R.string.doaa3, 1),
                        new ZekrDM(R.string.doaa4m, 4),
                        new ZekrDM(R.string.doaa5m, 1),
                        new ZekrDM(R.string.doaa6, 3),
                        new ZekrDM(R.string.doaa7, 7),
                        new ZekrDM(R.string.doaa8, 1),
                        new ZekrDM(R.string.doaa9, 1),
                        new ZekrDM(R.string.doaa10, 3),
                        new ZekrDM(R.string.doaa11, 3),
                        new ZekrDM(R.string.doaa12, 3),
                        new ZekrDM(R.string.doaa13m, 1),
                        new ZekrDM(R.string.doaa14m, 1),
                        new ZekrDM(R.string.doaa15, 10),
                        new ZekrDM(R.string.doaa16m, 3),
                        new ZekrDM(R.string.doaa18, 3),
                        new ZekrDM(R.string.doaa19, 10));
            case "morning":
                    return Arrays.asList(
                            new ZekrDM(R.string.aya1, 1),
                            new ZekrDM(R.string.aya2, 3),
                            new ZekrDM(R.string.aya3, 3),
                            new ZekrDM(R.string.aya4, 3),
                            new ZekrDM(R.string.doaa1s, 1),
                            new ZekrDM(R.string.doaa2s, 1),
                            new ZekrDM(R.string.doaa3, 1),
                            new ZekrDM(R.string.doaa4s, 4),
                            new ZekrDM(R.string.doaa5s, 1),
                            new ZekrDM(R.string.doaa6, 3),
                            new ZekrDM(R.string.doaa7, 7),
                            new ZekrDM(R.string.doaa8, 1),
                            new ZekrDM(R.string.doaa9, 1),
                            new ZekrDM(R.string.doaa10, 3),
                            new ZekrDM(R.string.doaa11, 3),
                            new ZekrDM(R.string.doaa12, 3),
                            new ZekrDM(R.string.doaa13s, 1),
                            new ZekrDM(R.string.doaa14s, 1),
                            new ZekrDM(R.string.doaa15, 10),
                            new ZekrDM(R.string.doaa16s, 3),
                            new ZekrDM(R.string.doaa17s, 3),
                            new ZekrDM(R.string.doaa18, 3),
                            new ZekrDM(R.string.doaa19, 10));
            case "pray":
                return Arrays.asList(
                        new ZekrDM(R.string.doaaaSalah1,1),
                        new ZekrDM(R.string.doaaaSalah2,3),
                        new ZekrDM(R.string.doaaaSalah3,3),
                        new ZekrDM(R.string.doaaaSalah4,3),
                        new ZekrDM(R.string.doaaaSalah5,1),
                        new ZekrDM(R.string.doaaaSalah6,1),
                        new ZekrDM(R.string.doaaaSalah7,1),
                        new ZekrDM(R.string.doaaaSalah8,1),
                        new ZekrDM(R.string.doaaaSalah9,1),
                        new ZekrDM(R.string.doaaaSalah10,33),
                        new ZekrDM(R.string.doaaaSalah11,10),
                        new ZekrDM(R.string.doaaaSalah12,1),
                        new ZekrDM(R.string.doaaaSalah13,7));
            default:
                // Log an error message if the type does not match any case
                Log.e("getData", "Type does not match" );
                // Return an empty list if no match is found
                return java.util.Collections.emptyList();
        }
    }
}
