package com.example.datafromapitestingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.datafromapitestingapp.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private JSONPlaceHolderAPI jsonPlaceHolderAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request originalRequest = chain.request();

                    Request newRequest = originalRequest.newBuilder()
                            .addHeader("Indra", "Jabriko")
                            .build();
                    return chain.proceed(newRequest);
                })
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://api.aladhan.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        jsonPlaceHolderAPI = retrofit.create(JSONPlaceHolderAPI.class);

        getDate();
    }

    private void getDate() {
        Call<DateHijri> call = jsonPlaceHolderAPI.getDate();

        call.enqueue(new Callback<DateHijri>() {
            @Override
            public void onResponse(Call<DateHijri> call, Response<DateHijri> response) {
                if (!response.isSuccessful()) {
                    mainBinding.textResult.setText("Code: " + response.code());
                    Log.d("Tag", "Code: " + response.code());
                    return;
                }
                mainBinding.textResult.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<DateHijri> call, Throwable t) {
                mainBinding.textResult.setText(t.getMessage());
                Log.d("Tag", t.getMessage());
                mainBinding.textResult.setText(t.getMessage());
            }
        });
    }
}