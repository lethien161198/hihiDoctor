package com.example.test.modules.services

import com.example.test.model.BodyResponseDTO
import com.example.test.model.JwtResponse
import com.example.test.model.LoginRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
interface Api {
    @POST("bac_si/login")
    fun SignIn(
        @Body param: LoginRequest
    ): Observable<BodyResponseDTO<JwtResponse>>

}