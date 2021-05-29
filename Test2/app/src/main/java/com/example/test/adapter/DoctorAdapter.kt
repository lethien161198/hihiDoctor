package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.commons.utils.GlideImage
import com.example.test.databinding.ItemDoctorBinding
import com.example.test.model.Doctor

class DoctorAdapter(private var data: MutableList<Doctor>?,
                    private var context: Context?,
                    private val onClickItemDoctor: OnClickItemDoctor) :
    RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemDoctorBinding) : RecyclerView.ViewHolder(binding.root) {
        val bind: ItemDoctorBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDoctorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.avatar.setImageResource(R.drawable.avatar)
        holder.bind.nameDoctor.text = data!![position].name
        holder.bind.cardview.startAnimation(AnimationUtils.loadAnimation(context,R.anim.item_anim_from_right))
        holder.bind.itemDoctor.setOnClickListener{
            onClickItemDoctor.onClickItem("")
        }
        holder.bind.edit.setOnClickListener {
            onClickItemDoctor.onClickEdit("")
        }

        holder.bind.delete.setOnClickListener {
            onClickItemDoctor.onClickDelete("")
        }
    }

    override fun getItemCount(): Int {
        if (data!!.size > 0) {
            return data!!.size
        }
        return 0    }

    interface OnClickItemDoctor{
        fun onClickItem(id:String)
        fun onClickEdit(id:String)
        fun onClickDelete(id:String)
    }
}