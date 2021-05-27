package com.example.test.modules.viewmodel

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel
import com.example.test.commons.utils.Constants
import com.example.test.commons.utils.SharedPreferenceHelper
import com.example.test.model.LoginRequest
import com.example.test.modules.services.Api
import com.example.test.modules.services.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoginViewModel:BaseViewModel() {
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var message = MutableLiveData<String>()
    var busy = MutableLiveData<Int>(8)

    @SuppressLint("CheckResult")
    fun onClickLogin() {
        busy.value = 0
        //var request = LoginRequest(username = username.value,password = password.value)

        var request = LoginRequest(username = "leducthien@gmail.com",password = "1234567890")

        RetrofitClient.createService(Api::class.java).SignIn(request)
            .delay(2000,TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{
                message.value = it.message!!
                if(message.value.equals("Login Success")){
                    SharedPreferenceHelper.setString(Constants.PREF_EMAIL,request.username)
                    SharedPreferenceHelper.setString(Constants.PREF_PASSWORD,request.password)
                    SharedPreferenceHelper.setString(Constants.PREF_TOKEN,it.token)
                }
                busy.value = 8
            }
    }
}