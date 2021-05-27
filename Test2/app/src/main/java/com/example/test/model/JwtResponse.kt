package com.example.test.model


import com.example.test.model.SubscriptionPlan
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class JwtResponse {
    @SerializedName("canShowTrainingRouteSuggestion")
    @Expose
    var canShowTrainingRouteSuggestion: Boolean? = null

    @SerializedName("canShowTutorialSuggestion")
    @Expose
    var canShowTutorialSuggestion: Boolean? = null

    @SerializedName("createdOn")
    @Expose
    var createdOn: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null

    @SerializedName("emailVerified")
    @Expose
    var emailVerified: Boolean? = null

    @SerializedName("firstLogin")
    @Expose
    var firstLogin: Boolean? = null

    @SerializedName("first_name")
    @Expose
    var firstName: String? = null

    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("imgUrl")
    @Expose
    var imgUrl: String? = null

    @SerializedName("lang")
    @Expose
    var lang: String? = null

    @SerializedName("last_name")
    @Expose
    var lastName: String? = null

    @SerializedName("phone")
    @Expose
    var phone: String? = null

    @SerializedName("referCode")
    @Expose
    var referCode: String? = null

    @SerializedName("socialSource")
    @Expose
    var socialSource: String? = null

    @SerializedName("subscriptionActiveDate")
    @Expose
    var subscriptionActiveDate: String? = null

    @SerializedName("subscriptionExpiredDate")
    @Expose
    var subscriptionExpiredDate: String? = null

    @SerializedName("subscriptionPlan")
    @Expose
    var subscriptionPlan: SubscriptionPlan? = null

    @SerializedName("token")
    @Expose
    var token: String? = null

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("vipViewCount")
    @Expose
    var vipViewCount: Int? = null

}