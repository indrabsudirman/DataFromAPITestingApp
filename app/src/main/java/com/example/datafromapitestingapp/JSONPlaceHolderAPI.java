package com.example.datafromapitestingapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderAPI {

    @GET("gToH?date")
    Call<DateHijri> getDate ();
}
