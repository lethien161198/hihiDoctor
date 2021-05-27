package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.commons.utils.GlideImage
import com.example.test.databinding.ItemNewsBinding
import com.example.test.databinding.ItemViewPagerBinding

class LatestNewsAdapter(private var data: MutableList<String>?,private var context: Context)  :
    RecyclerView.Adapter<LatestNewsAdapter.ViewHolder>(){
    class ViewHolder(binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root){
        val bind: ItemNewsBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind.imageNews.setImageResource(R.drawable.ic_launcher_background)
        holder.bind.nameNews.text = "Latest News"
    }

    override fun getItemCount(): Int {
        if (data!!.size > 0) {
            return data!!.size
        }
        return 0
    }
}