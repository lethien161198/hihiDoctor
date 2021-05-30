package com.example.test.modules.view.patients.allpatients

import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel
import com.example.test.model.Doctor
import com.example.test.model.Patient
import com.example.test.modules.services.DoctorsService
import com.example.test.modules.services.PatientsService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class PatientsViewModel : BaseViewModel() {
    var busy = MutableLiveData<Int>(8)
    var listPatient = MutableLiveData<MutableList<Patient>>()

    fun createListPatient() {
        busy.value = 0
        PatientsService.getAllPatient()
            .delay(2000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<MutableList<Patient>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: MutableList<Patient>) {
                    listPatient.value = t
                    busy.value = 8
                }

                override fun onError(e: Throwable) {
                    busy.value = 8
                }

                override fun onComplete() {
                    busy.value = 8
                }

            })


    }
}