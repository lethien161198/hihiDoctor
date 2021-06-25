package com.example.test.model.requestDTO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenRequest(

    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("email")
    @Expose
    var username: String? = null,

    @SerializedName("access_token")
    @Expose
    var token: String? = null
)