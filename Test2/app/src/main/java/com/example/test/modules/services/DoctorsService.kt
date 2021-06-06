package com.example.test.modules.services

import com.example.test.model.Doctor
import io.reactivex.Observable

class DoctorsService {
    companion object{
        fun getAllDoctor():Observable<MutableList<Doctor>>{
            return Observable.create{
                var list = mutableListOf<Doctor>()
                list.add(Doctor(name = "Thien Le Duc" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                list.add(Doctor(name = "Thien Le Duc", description = "PTIT" ))
                it.onNext(list)
            }
        }
    }
}