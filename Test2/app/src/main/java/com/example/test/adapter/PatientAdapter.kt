package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.ItemDoctorBinding
import com.example.test.databinding.ItemPatientBinding
import com.example.test.model.Doctor
import com.example.test.model.Patient

class PatientAdapter(
    private var data: MutableList<Patient>,
    private var context: Context,
    private val onClickItemDoctor: OnClickItemPatient
) : RecyclerView.Adapter<PatientAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemPatientBinding) : RecyclerView.ViewHolder(binding.root) {
        val bind: ItemPatientBinding = binding
    }

    interface OnClickItemPatient {
        fun onClickItem(id: String)
        fun onClickEdit(id: String)
        fun onClickDelete(id: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPatientBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.cardview.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.item_anim_from_right
            )
        )
        holder.bind.itemPatient.setOnClickListener {
            onClickItemDoctor.onClickItem("")
        }
        holder.bind.edit.setOnClickListener {
            onClickItemDoctor.onClickEdit("")
        }

        holder.bind.delete.setOnClickListener {
            onClickItemDoctor.onClickDelete("")
        }
        var patient = data[position]
        holder.bind.namePatient.text = patient.name
        holder.bind.agePatient.text = patient.age.toString()
//        holder.bind.diagnostic.text = patient.description
//        holder.bind.date.text = "30/4/1975"
//        holder.bind.clinic.text = "Phong kham da khoa Tam Duc"

    }

    override fun getItemCount(): Int {
        if (data.size > 0) {
            return data.size
        }
        return 0
    }
}
