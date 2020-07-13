package com.example.showcars.ui

internal interface ApiStatus {
    fun isLoading()
    fun onSuccess()
    fun onFailure(message: String?)
}