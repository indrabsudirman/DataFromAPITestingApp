package com.example.datafromapitestingapp;


import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("hijri")
    private Hijri hijri;

    public Hijri getHijri() {
        return hijri;
    }

}
