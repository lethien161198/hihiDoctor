package com.example.test.view.author

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.R
import com.example.test.base.BaseFragment
import com.example.test.databinding.FragmentRegisterBinding


class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString("ARG_PARAM1")
            param2 = it.getString("ARG_PARAM2")
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                    putString("ARG_PARAM2", param2)
                }
            }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_register

    override fun initComponent(viewBinding: FragmentRegisterBinding) {
        viewBinding.navigateToLogin.setOnClickListener {
            replaceFragment(LoginFragment(),"login",true)
        }
    }
}