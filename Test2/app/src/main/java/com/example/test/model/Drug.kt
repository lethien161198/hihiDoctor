package com.example.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Drug(
    @SerializedName("id")
    @Expose
    var id: String = "",

    @SerializedName("name")
    @Expose
    var name: String = "",

    @SerializedName("type")
    @Expose
    var type: String = "",

    @SerializedName("use")
    @Expose
    var use: String = "",

    @SerializedName("description")
    @Expose
    var description: String = "",

    @SerializedName("image")
    @Expose
    var image: String = "",
)
