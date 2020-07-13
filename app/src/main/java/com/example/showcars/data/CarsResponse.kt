package com.example.showcars.data


import com.google.gson.annotations.SerializedName

data class CarsResponse(
    @SerializedName("data")
    val `data`: List<Data>? = null,
    @SerializedName("status")
    val status: Int? = null
)