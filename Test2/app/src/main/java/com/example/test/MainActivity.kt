package com.example.test

import android.os.Bundle
import android.util.Log
import com.example.test.commons.base.BaseActivity
import com.example.test.modules.MainFragment
import com.example.test.modules.view.author.signIn.SignInFragment


class MainActivity : BaseActivity() {

    override fun initComponent(saveInstantState: Bundle?) {
        addFragment(MainFragment(),R.id.container,"mainfragment",false)
    }
    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("1234", "onCreate: ")
    }
}