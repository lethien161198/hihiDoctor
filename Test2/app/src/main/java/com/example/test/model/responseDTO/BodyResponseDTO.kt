package com.example.test.model.responseDTO

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class BodyResponseDTO<T> (
    @SerializedName("data")
    @Expose
    var data: T? = null,
    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("access_token")
    @Expose
    var token: String? = null,

    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean? = false


)
