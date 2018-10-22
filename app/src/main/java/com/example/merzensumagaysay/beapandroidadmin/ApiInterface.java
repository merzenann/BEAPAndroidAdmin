package com.example.merzensumagaysay.beapandroidadmin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by merzensumagaysay on 22/10/2018.
 */

public interface ApiInterface {

    @GET("fetch.php")
  //  Call<Fetch> performCheckbox();
    Call<List<Fetch>> getFetch();
}
