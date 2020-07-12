package com.example.showcars.ui;

interface ApiStatus {
    void isLoading();

    void success();

    void failed(String message);
}
