package com.example.showcars;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.showcars.data.CarsResponse;
import com.example.showcars.networking.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsRepository {


    public MutableLiveData<CarsResponse> getCars(int page) {
        final MutableLiveData<CarsResponse> data = new MutableLiveData<>();
        ApiClient.getClient().getCars(page).enqueue(new Callback<CarsResponse>() {
            @Override
            public void onResponse(Call<CarsResponse> call, Response<CarsResponse> response) {
                if (response.isSuccessful()) {
                    CarsResponse carsResponse = response.body();
                    if (carsResponse != null) {
                        data.postValue(carsResponse);
                        Log.d("CarsRepository", "response is " + response.body().toString());
                    } else {
                        Log.d("CarsRepository", "data is null");
                    }
                    Log.d("CarsRepository", "response is " + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<CarsResponse> call, Throwable t) {
                Log.d("CarsRepository", "onFailure " + t.getMessage());
            }
        });

        return data;
    }
}
