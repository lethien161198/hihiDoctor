package com.example.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.DrugItemBinding
import com.example.test.model.Drug

class DrugAdapter(var listDrug: MutableList<Drug>) : RecyclerView.Adapter<DrugAdapter.DrugViewHolder>() {
    interface DrugClickListener {
        fun itemOnClick(position: Int, drug: Drug)
    }
    var mListener: DrugClickListener? = null
    class DrugViewHolder(val mBinding: DrugItemBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugViewHolder {
        val mBinding: DrugItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.drug_item,
            parent,
            false
        )
        return DrugViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: DrugViewHolder, position: Int) {
        val currentDrug = listDrug[position]
        val context = holder.itemView.context
        holder.mBinding.nameTextView.text = currentDrug.name
        holder.mBinding.typeTextView.text = currentDrug.type
        holder.mBinding.descriptionTextView.text = currentDrug.description
        holder.mBinding.useTextView.text = currentDrug.use

        holder.itemView.setOnClickListener {
            mListener?.itemOnClick(position, currentDrug)
        }
    }

    override fun getItemCount(): Int {
        return listDrug.size
    }
}
