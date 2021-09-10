package com.example.datafromapitestingapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderAPI {

    @GET("gToH?date")
    Call <DateHijri> getDate ();
}
