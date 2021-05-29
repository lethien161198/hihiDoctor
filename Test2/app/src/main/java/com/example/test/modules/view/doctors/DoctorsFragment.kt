package com.example.test.modules.view.doctors

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.adapter.DoctorAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentDoctorsBinding
import kotlinx.android.synthetic.main.header_title.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DoctorsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DoctorsFragment : BaseFragment<FragmentDoctorsBinding>() , DoctorAdapter.OnClickItemDoctor{
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
         * @return A new instance of fragment DoctorsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DoctorsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override val layoutRes: Int
        get() = R.layout.fragment_doctors

    override fun initComponent(viewBinding: FragmentDoctorsBinding) {
        //CustomProgress.FadingCircle(viewBinding.progress)
        viewBinding.doctorRecycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        val viewModel: DoctorsViewModel = ViewModelProvider(this).get(DoctorsViewModel::class.java)
        viewModel.createListDoctor()
        viewModel.listDoctor.observe(this,{
            val doctorAdapter = DoctorAdapter(it,requireContext(),this)
            viewBinding.doctorRecycler.adapter = doctorAdapter
            doctorAdapter.notifyDataSetChanged()
        })

        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_baseline_arrow_back_ios_new_24)
        viewBinding.header.title.text = context?.resources?.getString(R.string.doctor)
        viewBinding.header.btnLeft.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onClickItem(id: String) {
    }

    override fun onClickEdit(id: String) {
    }

    override fun onClickDelete(id: String) {
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Delete Doctor")
        builder?.setMessage("Do you delete this doctor ?")

        builder?.setPositiveButton("Yes") { dialog, which ->
            showMessage("yes")
        }

        builder?.setNegativeButton("No") { dialog, which ->
           showMessage("no")
        }
        builder?.show()
    }
}