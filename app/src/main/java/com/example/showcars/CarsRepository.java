package com.example.showcars;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.showcars.data.CarsResponse;
import com.example.showcars.data.Data;
import com.example.showcars.networking.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarsRepository {

    @SuppressLint("LogNotTimber")
    public MutableLiveData<List<Data>> getCars(int page) {
        final MutableLiveData<List<Data>> data = new MutableLiveData<>();
        ApiClient.getClient().getCars(page).enqueue(new Callback<CarsResponse>() {
            @Override
            public void onResponse(Call<CarsResponse> call, Response<CarsResponse> response) {
                Log.d("CarsRepository", "page is " + page);
                if (response.isSuccessful()) {
                    CarsResponse carsResponse = response.body();
                    if (carsResponse != null) {
                        if (carsResponse.getStatus() == 1) {
                            data.postValue(carsResponse.getData());
                        } else {
                            Log.d("CarsRepository", "response is00 " + response.body().toString());
                        }

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
