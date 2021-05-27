package com.example.test

import android.os.Bundle
import android.util.Log
import com.example.test.base.BaseActivity
import com.example.test.view.author.LoginFragment


class MainActivity : BaseActivity() {

    override fun initComponent(saveInstantState: Bundle?) {
        addFragment(LoginFragment(),R.id.container,"login",false)
    }
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("1234", "onCreate: ")
    }
}