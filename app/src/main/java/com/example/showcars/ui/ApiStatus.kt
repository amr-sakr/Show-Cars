package com.example.showcars.ui

interface ApiStatus {
    fun isLoading()
    fun onSuccess()
    fun onFailure(message: String?)
}