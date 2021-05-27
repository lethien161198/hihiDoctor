package com.example.test.commons.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
import com.example.test.R

class GlideImage {
    companion object{
        fun loadImage(context:Context, url:String, img:ImageView){
            Glide.with(context)
                .load(url)
                .error(R.drawable.ic_launcher_foreground)
                .into(img);
        }
    }
}