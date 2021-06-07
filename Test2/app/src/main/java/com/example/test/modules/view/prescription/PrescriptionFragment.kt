package com.example.test.modules.view.prescription

import com.example.test.R
import com.example.test.commons.base.BaseFragment
import com.example.test.databinding.FragmentPrescriptionBinding
import com.example.test.databinding.PrescriptionItemBinding
import com.example.test.model.PrescriptionLayout

class PrescriptionFragment :
    BaseFragment<FragmentPrescriptionBinding, PrescriptionViewModel>(PrescriptionViewModel::class.java) {
    private val listLayout = mutableListOf<PrescriptionLayout>()
    override val layoutRes: Int
        get() = R.layout.fragment_prescription

    override fun initComponent(viewBinding: FragmentPrescriptionBinding) {
//        listLayout.
        createLayout(viewBinding)
        viewBinding.addButton.setOnClickListener {
            createLayout(viewBinding)
        }
    }

    private fun createLayout(viewBinding: FragmentPrescriptionBinding) {
        val layoutBinding: PrescriptionItemBinding = PrescriptionItemBinding.inflate(layoutInflater)
        val layout = PrescriptionLayout(
            layoutBinding.drugRankTextView,
            layoutBinding.nameEditText,
            layoutBinding.numberEditText,
            layoutBinding.typeEditText,
            layoutBinding.useEditText
        )
        listLayout.add(layout)
        layoutBinding.deleteImageView.setOnClickListener {
            viewBinding.containerLinearLayout.removeView(layoutBinding.root)
            listLayout.remove(layout)
            for (i in 0 until listLayout.size) {
                listLayout[i].drugRank.text = "Thuoc ${i + 1}"
            }
        }
        layoutBinding.drugRankTextView.text = "Thuoc ${listLayout.size}"
//        layoutBinding.nameEditText.text =
//        layoutBinding.numberEditText.text =
//        layoutBinding.typeEditText.text =
//        layoutBinding.useEditText.text =
        viewBinding.containerLinearLayout.addView(layoutBinding.root)
    }
}
