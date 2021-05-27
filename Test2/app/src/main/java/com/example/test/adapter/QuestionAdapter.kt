package com.example.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ItemQuestionBinding
import com.example.test.model.Question

class QuestionAdapter(private var data: MutableList<Question>?) :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {
    class ViewHolder(binding: ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root){
        val bind: ItemQuestionBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemQuestionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.question.text = data!![position].question
        holder.bind.answer.text = data!![position].answer
    }

    override fun getItemCount(): Int {
        if (data!!.size > 0) {
            return data!!.size
        }
        return 0
    }

}