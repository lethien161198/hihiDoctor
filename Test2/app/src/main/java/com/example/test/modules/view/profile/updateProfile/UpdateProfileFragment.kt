package com.example.test.modules.view.profile.updateProfile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.commons.utils.Constants
import com.example.test.commons.utils.SharedPreferenceHelper
import com.example.test.databinding.FragmentUpdateProfileBinding
import com.example.test.model.Patient
import com.example.test.model.requestDTO.UpdateDoctorRequest
import com.example.test.model.responseDTO.BodyResponseDTO
import com.example.test.model.responseDTO.Data
import com.example.test.modules.services.Api
import com.example.test.modules.services.RetrofitClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_update_profile.*
import kotlinx.android.synthetic.main.header_title.view.*
import java.util.concurrent.TimeUnit

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UpdateDoctorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateProfileFragment :
    BaseFragment<FragmentUpdateProfileBinding, UpdateProfileViewModel>(UpdateProfileViewModel::class.java) {
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
         * @return A new instance of fragment UpdateDoctorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UpdateProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_update_profile

    override fun initComponent(viewBinding: FragmentUpdateProfileBinding) {
        viewBinding.header.title.text = "Update Doctor"
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_baseline_arrow_back_ios_new_24)
        viewBinding.header.btnLeft.setOnClickListener {
            activity?.onBackPressed()
        }
        viewBinding.editName.setOnClickListener {
            if (!viewBinding.tvName.isEnabled) {
                viewBinding.tvName.isEnabled = true
            }
            viewBinding.tvName.requestFocus()
            viewBinding.tvName.setText("")
        }
        viewBinding.head.setOnClickListener {
            viewBinding.tvName.clearFocus()
            view?.let { it1 -> context?.hideKeyboard(it1) }
        }
        var username = SharedPreferenceHelper.getString(Constants.PREF_EMAIL)
        var password = SharedPreferenceHelper.getString(Constants.PREF_PASSWORD)
        var token = SharedPreferenceHelper.getString(Constants.PREF_TOKEN)

        var updateDoctor = UpdateDoctorRequest(password,username, token,
            viewBinding.tvName.text.toString(),
            viewBinding.phone.text.toString(),
            viewBinding.sex.text.toString(),
            Integer.parseInt(viewBinding.age.text.toString()),
            viewBinding.fb.text.toString(),
            viewBinding.zalo.text.toString(),
            viewBinding.description.text.toString(),
            "",
            viewBinding.address.text.toString())
        viewBinding.updateDoctor.setOnClickListener {
            RetrofitClient.createService(Api::class.java).updateDoctor(updateDoctor)
                .delay(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<BodyResponseDTO<Data>> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(t: BodyResponseDTO<Data>) {
                        t.message?.let { showMessage(it) }
                    }

                    override fun onError(e: Throwable) {
                        e.message?.let { showMessage(it) }
                    }

                    override fun onComplete() {

                    }

                })
        }

    }
}