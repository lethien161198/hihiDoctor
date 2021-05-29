package com.example.test.modules.view.clinic

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Clinic(
    @SerializedName("id")
    @Expose
    var id: String = "",

    @SerializedName("name")
    @Expose
    var name: String = "",

    @SerializedName("address")
    @Expose
    var address: String = "",

    @SerializedName("description")
    @Expose
    var description: String = "",

    @SerializedName("image")
    @Expose
    var image: String = "",
)
