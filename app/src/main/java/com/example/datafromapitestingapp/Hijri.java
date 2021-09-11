package com.example.datafromapitestingapp;

import com.google.gson.annotations.SerializedName;

public class Hijri {


    private String date;
    @SerializedName("format")
    private String format;
    @SerializedName("day")
    private String day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
