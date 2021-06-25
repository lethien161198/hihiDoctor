package com.example.test.modules.services

import com.example.test.model.Doctor
import com.example.test.model.Patient
import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.model.responseDTO.JwtResponse
import com.example.test.model.requestDTO.LoginRequest
import com.example.test.model.requestDTO.RegisterRequest
import com.example.test.model.requestDTO.TokenRequest
import com.example.test.model.requestDTO.UpdateDoctorRequest
import com.example.test.model.responseDTO.Data
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @POST("bac_si/login")
    fun signIn(
        @Body param: LoginRequest
    ): Observable<BodyResponseDTO<JwtResponse>>

    @POST("bac_si/register")
    fun register(
        @Body param: RegisterRequest
    ): Observable<BodyResponseDTO<Data>>

    @POST("benh_nhan/all")
    fun getAllPatients(
        @Body param: TokenRequest
    ): Observable<BodyResponseDTO<MutableList<Patient>>>

    @POST("bac_si/all")
    fun getAllDoctors(
        @Body param: TokenRequest
    ): Observable<BodyResponseDTO<MutableList<Doctor>>>

    @POST("bac_si/update_doctor")
    fun updateDoctor(
        @Body param: UpdateDoctorRequest
    ): Observable<BodyResponseDTO<Data>>


}