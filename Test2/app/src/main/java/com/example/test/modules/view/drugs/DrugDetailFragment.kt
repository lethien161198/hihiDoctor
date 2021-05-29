package com.example.test.modules.view.drugs

import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentDrugDetailBinding
import com.example.test.model.Drug
import kotlinx.android.synthetic.main.header_title.view.*

class DrugDetailFragment(val drug: Drug) : BaseFragment<FragmentDrugDetailBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_drug_detail

    override fun initComponent(viewBinding: FragmentDrugDetailBinding) {
        viewBinding.header.title.text = "Medicine Detail"
        viewBinding.header.btnLeft.setOnClickListener {
            activity?.onBackPressed()
        }
        viewBinding.header.btnLeft.setImageResource(R.drawable.ic_baseline_arrow_back_ios_new_24)
        viewBinding.nameTextView.text = drug.name
        viewBinding.typeTextView.text = drug.type
        viewBinding.descriptionTextView.text = drug.description
        viewBinding.useTextView.text = drug.use
    }
}
