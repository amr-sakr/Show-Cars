package com.example.showcars.data


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("brand")
    val brand: String? = null,
    @SerializedName("constructionYear")
    val constructionYear: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imageUrl")
    val imageUrl: String? = null,
    @SerializedName("isUsed")
    val isUsed: Boolean? = null
)