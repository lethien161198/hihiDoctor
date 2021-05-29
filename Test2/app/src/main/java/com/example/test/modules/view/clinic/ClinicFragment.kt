package com.example.test.modules.view.clinic

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.adapter.ClinicAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentClinicBinding
import com.example.test.model.Clinic
import kotlinx.android.synthetic.main.header_title.view.*
import java.util.*

class ClinicFragment : BaseFragment<FragmentClinicBinding>(), ClinicAdapter.ClinicClickListener {
    override val layoutRes: Int
        get() = R.layout.fragment_clinic

    override fun initComponent(viewBinding: FragmentClinicBinding) {

        viewBinding.header.title.text = "Clinic"
        viewBinding.header.btnLeft.setOnClickListener {
            activity?.onBackPressed()
        }
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_baseline_arrow_back_ios_new_24)

        val listClinic: MutableList<Clinic> = mutableListOf()
        listClinic.add(Clinic("1", "Benh vien Bach Mai", "Giai Phong", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("2", "Benh vien Quan Y", "Phung Hung", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("3", "Benh vien Da Khoa Ninh Binh", "Ninh Binh", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("4", "Benh vien Rang Ham Mat Trung Uong", "gan Ho Guom", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("5", "Benh vien Viet Duc", "gan Ho Guom", "Nam se tao desciption sau", "Nam tao image sau"))
        val recycler: RecyclerView = viewBinding.clinicRecyclerView
        val clinicAdapter = ClinicAdapter(listClinic)
        clinicAdapter.mListener = this
        recycler.adapter = clinicAdapter
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun itemOnClick(position: Int, clinic: Clinic) {
        val uri = String.format(Locale.ENGLISH, "geo:21.000132,105.8386603")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }
}
