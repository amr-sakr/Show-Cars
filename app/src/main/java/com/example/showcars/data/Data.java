package com.example.showcars.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("constractionYear")
    @Expose
    private String constractionYear;
    @SerializedName("isUsed")
    @Expose
    private boolean isUsed;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getConstractionYear() {
        return constractionYear;
    }

    public void setConstractionYear(String constractionYear) {
        this.constractionYear = constractionYear;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", constractionYear='" + constractionYear + '\'' +
                ", isUsed=" + isUsed +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
