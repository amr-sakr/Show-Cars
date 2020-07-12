package com.example.showcars.networking;

import com.example.showcars.data.CarsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServices {

    @GET("cars")
    Call<CarsResponse> getCars(@Query("page") int Page);


}
