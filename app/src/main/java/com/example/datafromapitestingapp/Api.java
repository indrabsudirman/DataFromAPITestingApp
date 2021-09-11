package com.example.datafromapitestingapp;

import com.google.gson.annotations.SerializedName;

public class Api {

    @SerializedName("code")
    private Integer code;
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Data data;

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public Data getData() {
        return data;
    }
}
