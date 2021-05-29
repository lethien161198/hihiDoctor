package com.example.test.modules.view.drugs

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.adapter.DrugAdapter
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentDrugBinding
import com.example.test.model.Drug

class DrugFragment : BaseFragment<FragmentDrugBinding>(), DrugAdapter.DrugClickListener {
    override fun initComponent(viewBinding: FragmentDrugBinding) {
        val listDrug: MutableList<Drug> = mutableListOf()
        val recycler: RecyclerView = viewBinding.drugRecyclerView

        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        listDrug.add(Drug("1", "Thuoc 1", "bot", "ngay dung 2-3 vien do bac si quyet dinh", "Thien an cut cho"))
        var mDrugAdapter = DrugAdapter(listDrug)
        recycler.adapter = mDrugAdapter
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
    override val layoutRes: Int
        get() = R.layout.fragment_drug

    override fun itemOnClick(position: Int, drug: Drug) {
    }
}
