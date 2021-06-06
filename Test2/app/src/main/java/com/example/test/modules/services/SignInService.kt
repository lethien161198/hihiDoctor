package com.example.test.modules.services

import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.model.responseDTO.JwtResponse
import com.example.test.model.requestDTO.LoginRequest
import io.reactivex.Observable

class SignInService {
    companion object{
        fun signIn(request: LoginRequest): Observable<BodyResponseDTO<JwtResponse>> {
            return RetrofitClient.createService(Api::class.java).signIn(request)
        }
    }
}