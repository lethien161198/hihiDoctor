package com.example.test.modules.view.home

import androidx.lifecycle.MutableLiveData
import com.example.test.commons.base.BaseViewModel

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