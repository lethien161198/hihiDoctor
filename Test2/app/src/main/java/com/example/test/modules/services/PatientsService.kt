package com.example.test.modules.services

import com.example.test.model.Doctor
import com.example.test.model.Patient
import io.reactivex.Observable

class PatientsService {
    companion object{
        fun getAllPatient(): Observable<MutableList<Patient>> {
            return Observable.create{
                var list = mutableListOf<Patient>()
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))
                list.add(Patient(name = "Thien Le Duc",age = 23 ))



                it.onNext(list)
            }
        }
    }
}