package com.example.test.view

import com.example.test.R
import com.example.test.base.BaseFragment
import com.example.test.databinding.FragmentHomeBinding
import com.example.test.viewmodel.HomeViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun initComponent(viewBinding: FragmentHomeBinding) {

    }

    override val layoutRes: Int
        get() = R.layout.fragment_home

}