package com.example.test.modules.view.author.signUp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel
import com.example.test.model.requestDTO.RegisterRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.model.responseDTO.Data
import com.example.test.model.responseDTO.JwtResponse
import com.example.test.modules.services.RegisterService
import com.example.test.modules.services.SignInService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RegisterViewModel : BaseViewModel() {
    var busy = MutableLiveData(8)
    var message = MutableLiveData<String>()
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var name = MutableLiveData("")
    var phone = MutableLiveData("")
    var isSuccess = MutableLiveData(false)
    fun onClickRegister() {
        busy.value = 0
        if (name.value == null){
            name.value = ""
        }
        if (email.value == null){
            email.value = ""
        }
        if (password.value == null){
            password.value = ""
        }
        if (phone.value == null){
            phone.value = ""
        }
        val request = RegisterRequest(
            name = name.value,
            username = email.value,
            phone = phone.value,
            password = password.value
        )
        RegisterService.register(request)
            .delay(2000, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<BodyResponseDTO<Data>> {
                override fun onSubscribe(d: Disposable) {
                    //compositeDisposable.add(d)
                }

                override fun onNext(it: BodyResponseDTO<Data>) {
                    if (it.isSuccess == true) {
                        message.value = "Register Success"
                        isSuccess.value = true
                    }
                    else{

                        message.value = it.message!!
                    }
                }

                override fun onError(e: Throwable) {
                    message.value = e.message
                    Log.d("1234", "onError: ${e.message}")
                    busy.value = 8
                }

                override fun onComplete() {
                    busy.value = 8
                }

            })
    }
}