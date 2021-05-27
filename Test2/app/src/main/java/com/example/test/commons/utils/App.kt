package com.example.test.commons.utils

import android.app.Application

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPreferenceHelper.initialize(context = applicationContext)
    }
}