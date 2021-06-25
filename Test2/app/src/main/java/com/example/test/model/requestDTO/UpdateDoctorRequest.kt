package com.example.test.model.requestDTO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UpdateDoctorRequest(
    @SerializedName("password")
    @Expose
    var password: String? = null,

    @SerializedName("email")
    @Expose
    var username: String? = null,

    @SerializedName("access_token")
    @Expose
    var token: String? = null,

    @SerializedName("name")
    @Expose
    var name: String = "",
    @SerializedName("phone")
    @Expose
    var phone: String = "",
    @SerializedName("sex")
    @Expose
    var sex: String = "",
    @SerializedName("age")
    @Expose
    var age: Int = 0,
    @SerializedName("facebook_link")
    @Expose
    var facebook: String = "",
    @SerializedName("zalo_link")
    @Expose
    var zalo: String = "",
    @SerializedName("description")
    @Expose
    var description: String = "",
    @SerializedName("imageUrl")
    @Expose
    var imageUrl: String = "",
    @SerializedName("noi_lam_viec")
    @Expose
    var address: String = ""

)