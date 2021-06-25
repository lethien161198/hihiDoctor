package com.example.test.modules.services

import com.example.test.model.Doctor
import com.example.test.model.requestDTO.TokenRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import io.reactivex.Observable

class DoctorsService {
    companion object{
        fun getAllDoctor(request: TokenRequest):Observable<BodyResponseDTO<MutableList<Doctor>>>{
            return RetrofitClient.createService(Api::class.java).getAllDoctors(request)
        }
    }
}