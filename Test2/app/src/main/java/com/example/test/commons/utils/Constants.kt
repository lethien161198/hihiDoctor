package com.example.test.commons.utils

import com.example.test.BuildConfig

class Constants {
    companion object{
        const val baseUrl = BuildConfig.BASE_URL
        const val PREF_EMAIL = "email"
        const val PREF_PASSWORD = "password"
        const val PREF_TOKEN = "access_token"
    }
}