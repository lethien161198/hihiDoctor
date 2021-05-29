package com.example.test.modules.services

import com.example.test.model.BodyResponseDTO
import com.example.test.model.JwtResponse
import com.example.test.model.LoginRequest
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignInService {
    companion object{
        fun signIn(request: LoginRequest): Observable<BodyResponseDTO<JwtResponse>> {
            return RetrofitClient.createService(Api::class.java).SignIn(request)
        }
    }
}