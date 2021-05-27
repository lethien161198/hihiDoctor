package com.example.test.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.test.base.BaseViewModel

class HomeViewModel: BaseViewModel() {
    var list = MutableLiveData<MutableList<String>>()
    var message = MutableLiveData<String>()
    var lst = mutableListOf<String>()
    fun initList(){
        message.value = "hello"
        lst.add("abc")
        lst.add("abc")
        lst.add("abc")
        lst.add("abc")
        lst.add("abc")
        lst.add("abc")
        list.value = lst
    }
}