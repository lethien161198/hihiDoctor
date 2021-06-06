package com.example.test.modules.services

import com.example.test.model.requestDTO.LoginRequest
import com.example.test.model.requestDTO.RegisterRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.model.responseDTO.Data
import com.example.test.model.responseDTO.JwtResponse
import io.reactivex.Observable

class RegisterService {
    companion object{
        fun register(request: RegisterRequest): Observable<BodyResponseDTO<Data>> {
            return RetrofitClient.createService(Api::class.java).register(request)
        }
    }
}