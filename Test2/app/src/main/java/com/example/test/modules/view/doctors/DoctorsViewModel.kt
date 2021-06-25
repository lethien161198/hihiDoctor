package com.example.test.modules.view.doctors

import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel
import com.example.test.commons.utils.Constants
import com.example.test.commons.utils.SharedPreferenceHelper
import com.example.test.model.Doctor
import com.example.test.model.requestDTO.TokenRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.modules.services.DoctorsService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class DoctorsViewModel : BaseViewModel() {
    var busy = MutableLiveData<Int>(8)
    var listDoctor = MutableLiveData<MutableList<Doctor>>()

    fun createListDoctor() {
        busy.value = 0
        var username = SharedPreferenceHelper.getString(Constants.PREF_EMAIL)
        var password = SharedPreferenceHelper.getString(Constants.PREF_PASSWORD)
        var token = SharedPreferenceHelper.getString(Constants.PREF_TOKEN)
        var tokenRequest = TokenRequest(password,username,token)
        DoctorsService.getAllDoctor(tokenRequest)
            .delay(2000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<BodyResponseDTO<MutableList<Doctor>>> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: BodyResponseDTO<MutableList<Doctor>>) {
                    listDoctor.value = t.data!!
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