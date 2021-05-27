package com.example.test.modules.view.author

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.test.modules.MainFragment
import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.components.CustomProgress
import com.example.test.databinding.FragmentLoginBinding
import com.example.test.modules.viewmodel.LoginViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignInFragment : BaseFragment<FragmentLoginBinding>() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_login

    override fun initComponent(viewBinding: FragmentLoginBinding) {
        val viewModel:LoginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewBinding.loginViewModel = viewModel
        CustomProgress.FadingCircle(viewBinding.progress)
        viewBinding.edtUser.setText("")
        viewBinding.edtPass.setText("")
        viewBinding.navigateToSignUp.setOnClickListener {
            replaceFragment(SignUpFragment(),"signUp",true)
        }
        viewBinding.progress.visibility = View.GONE
        viewBinding.btnSignIn.setOnClickListener {
            //replaceFragment(MainFragment(),"main",true)
            viewModel.onClickLogin()
        }
        viewModel.message.observe(this,{
            Toast.makeText(context,it,Toast.LENGTH_LONG).show()
            if(it.equals("Login Success")){
                replaceFragment(MainFragment(),"main",true)
            }
        })
    }
}