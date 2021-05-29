package com.example.test.modules.view.clinic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ClinicItemBinding

class ClinicAdapter(private var listClinic: MutableList<Clinic>) :
    RecyclerView.Adapter<ClinicAdapter.ClinicViewHolder>() {

    interface ClinicClickListener {
        fun itemOnClick(position: Int, clinic: Clinic)
    }
    var mListener: ClinicClickListener? = null
    class ClinicViewHolder(val mBinding: ClinicItemBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicViewHolder {
        val mBinding: ClinicItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.clinic_item, parent, false
        )
        return ClinicViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ClinicViewHolder, position: Int) {
        val currentItem = listClinic[position]
        holder.mBinding.nameTextView.text = currentItem.name
        holder.mBinding.addressTextView.text = currentItem.address
        holder.itemView.setOnClickListener {
            mListener?.itemOnClick(position, currentItem)
        }
    }

    override fun getItemCount(): Int {
        return listClinic.size
    }
}
