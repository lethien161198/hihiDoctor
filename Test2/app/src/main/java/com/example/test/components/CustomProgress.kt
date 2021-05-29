package com.example.test.components

import android.widget.ProgressBar
import com.github.ybq.android.spinkit.style.FadingCircle

class CustomProgress {
    companion object{
        fun FadingCircle(progress:ProgressBar){
            progress.indeterminateDrawable = FadingCircle() 
        }
    }
}