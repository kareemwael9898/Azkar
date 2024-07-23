package com.kareem.azkar;

public class ZekrDM {
    private int text;
    private int count;

    public ZekrDM(int text, int count) {
        this.text = text;
        this.count = count;
    }

    public int getTextId() {
        return text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
