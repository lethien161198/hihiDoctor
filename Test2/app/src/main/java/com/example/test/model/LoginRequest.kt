package com.example.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("email")
    @Expose
    var username: String? = null
)
