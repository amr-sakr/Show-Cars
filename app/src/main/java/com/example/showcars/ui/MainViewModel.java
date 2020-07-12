package com.example.showcars.ui;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.showcars.CarsRepository;
import com.example.showcars.data.Car;
import com.example.showcars.data.CarsResponse;

import java.util.List;

public class MainViewModel extends ViewModel {

    ApiStatus apiStatus;
    private MutableLiveData<CarsResponse> response;
    private CarsRepository repository;
    private MutableLiveData<List<Car>> carsList;

    public MainViewModel(CarsRepository repository, ApiStatus apiStatus) {
        this.repository = repository;
        this.apiStatus = apiStatus;
    }

    public LiveData<List<Car>> getCars(int page) {
        apiStatus.isLoading();
        response = repository.getCars(page);
        carsList = new MutableLiveData<>();
        if (response != null) {
            if (response.getValue() != null) {
                int status = response.getValue().getStatus();
                if (status == 1) {
                    carsList.setValue(response.getValue().getData());
                    Log.d("MainViewModel", "status is// " + status);
                    apiStatus.success();
                } else if (status == 0) {
                    Log.d("MainViewModel", "status is " + status);
                    apiStatus.failed("Page Not Found");
                }
            } else {
                apiStatus.failed("Something went wrong");
            }
        } else {
            apiStatus.failed("Something went wrong");
        }


        return carsList;
    }


}
