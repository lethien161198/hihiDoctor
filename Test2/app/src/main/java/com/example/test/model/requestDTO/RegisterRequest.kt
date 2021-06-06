package com.example.test.model.requestDTO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("email")
    @Expose
    var username: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("phone")
    @Expose
    var phone: String? = null
)