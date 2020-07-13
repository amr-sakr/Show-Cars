package com.example.showcars

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree


class CarsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}