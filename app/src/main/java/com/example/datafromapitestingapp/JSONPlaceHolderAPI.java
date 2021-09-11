package com.example.datafromapitestingapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderAPI {

    @GET("gToH?date")
    Call <Api> getDate (@Query("date") String date);
}
