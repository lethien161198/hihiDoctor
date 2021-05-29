package com.example.test.modules.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel
import com.example.test.model.Doctor
import com.example.test.modules.services.DoctorsService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DoctorsViewModel:BaseViewModel() {
    var busy = MutableLiveData<Int>(8)
    var listDoctor = MutableLiveData<MutableList<Doctor>>()

    fun createListDoctor(){
        busy.value = 0

        DoctorsService.getAllDoctor()
            .delay(2000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<MutableList<Doctor>>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: MutableList<Doctor>) {
                    listDoctor.value = t
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {
                    busy.value = 8
                }

            })



    }
}