package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.commons.utils.GlideImage
import com.example.test.databinding.ItemQuestionBinding
import com.example.test.databinding.ItemViewPagerBinding
import com.example.test.model.Question

class NewsAdapter(private var data: MutableList<String>?,private var context: Context)  :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
    class ViewHolder(binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root){
        val bind: ItemViewPagerBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return NewsAdapter.ViewHolder(
            ItemViewPagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        GlideImage.loadImage(context, data!![position],holder.bind.image)
        //holder.bind.image.setImageResource(R.drawable.bg_design)
    }

    override fun getItemCount(): Int {
        if (data!!.size > 0) {
            return data!!.size
        }
        return 0
    }
}