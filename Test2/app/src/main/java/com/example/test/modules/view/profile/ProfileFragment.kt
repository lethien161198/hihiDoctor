package com.example.test.modules.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentProfileBinding
import com.example.test.modules.view.profile.updateProfile.UpdateProfileFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment :
    BaseFragment<FragmentProfileBinding, ProfileViewModel>(ProfileViewModel::class.java) {
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
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_profile

    override fun initComponent(viewBinding: FragmentProfileBinding) {
        viewBinding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }
        viewBinding.editProfile.setOnClickListener {
            replaceFragment(UpdateProfileFragment(), "updateprofilefragment", true)
        }
    }
}