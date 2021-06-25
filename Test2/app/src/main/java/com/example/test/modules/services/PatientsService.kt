package com.example.test.modules.services

import com.example.test.model.Doctor
import com.example.test.model.Patient
import com.example.test.model.requestDTO.TokenRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import io.reactivex.Observable

class PatientsService {
    companion object{
        fun getAllPatient(request: TokenRequest): Observable<BodyResponseDTO<MutableList<Patient>>> {
            return RetrofitClient.createService(Api::class.java).getAllPatients(request)
        }
    }
}