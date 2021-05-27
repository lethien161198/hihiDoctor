package com.example.test.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SubscriptionPlan {
    @SerializedName("abbreviationKey")
    @Expose
    var abbreviationKey: String? = null

    @SerializedName("createdOn")
    @Expose
    var createdOn: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("duration")
    @Expose
    var duration: Int? = null

    @SerializedName("free")
    @Expose
    var free: Boolean? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("lastUpdatedOn")
    @Expose
    var lastUpdatedOn: String? = null

    @SerializedName("lifeTime")
    @Expose
    var lifeTime: Boolean? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("position")
    @Expose
    var position: Int? = null

    @SerializedName("price")
    @Expose
    var price: Int? = null

    @SerializedName("type")
    @Expose
    var type: Int? = null

}