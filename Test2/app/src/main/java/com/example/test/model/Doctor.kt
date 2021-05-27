package com.example.test.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Doctor(
    @SerializedName("email")
    @Expose
     var email: String = "",
    @SerializedName("name")
    @Expose
     var name: String = "",
    @SerializedName("phone")
    @Expose
     var phone: String = "",
    @SerializedName("sex")
    @Expose
     var sex:String = "",
    @SerializedName("age")
    @Expose
     var age:Int = 0,
    @SerializedName("description")
    @Expose
     var description:String = "",
    @SerializedName("imageUrl")
    @Expose
     var imageUrl:String = ""
)