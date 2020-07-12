package com.example.showcars.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CarsResponse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("data")
    @Expose
    private List<Car> data = null;

    @SerializedName("error")
    @Expose
    private List<Car> error = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "CarsResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
