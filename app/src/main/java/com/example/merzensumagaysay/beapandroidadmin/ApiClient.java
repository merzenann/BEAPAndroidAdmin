package com.example.merzensumagaysay.beapandroidadmin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public class ApiClient
{

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.8.108/admin";

    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
