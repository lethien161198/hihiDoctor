package com.example.test.modules.services

import com.example.test.model.LoginRequest
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignInService {
    companion object{
        fun signIn(request: LoginRequest){
            RetrofitClient.createService(Api::class.java).SignIn(request)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe{
                }

        }
    }
}