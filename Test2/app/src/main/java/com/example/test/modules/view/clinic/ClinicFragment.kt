package com.example.test.modules.view.clinic

import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentClinicBinding

class ClinicFragment : BaseFragment<FragmentClinicBinding>(), ClinicAdapter.ClinicClickListener {
    override val layoutRes: Int
        get() = R.layout.fragment_clinic

    override fun initComponent(viewBinding: FragmentClinicBinding) {
        val listClinic: MutableList<Clinic> = mutableListOf()
        listClinic.add(Clinic("1", "Benh vien Bach Mai", "Giai Phong", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("2", "Benh vien Quan Y", "Phung Hung", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("3", "Benh vien Da Khoa Ninh Binh", "Ninh Binh", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("4", "Benh vien Rang Ham Mat Trung Uong", "gan Ho Guom", "Nam se tao desciption sau", "Nam tao image sau"))
        listClinic.add(Clinic("5", "Benh vien Viet Duc", "gan Ho Guom", "Nam se tao desciption sau", "Nam tao image sau"))
        val recycler: RecyclerView = viewBinding.clinicRecyclerView
        val clinicAdapter = ClinicAdapter(listClinic)
        recycler.adapter = clinicAdapter
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun itemOnClick(position: Int, clinic: Clinic) {
    }
}
