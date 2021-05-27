package com.example.test.components

import android.widget.ProgressBar
import com.github.ybq.android.spinkit.style.*


class CustomProgress {
    companion object{
        fun FadingCircle(progressBar: ProgressBar) {
            progressBar.indeterminateDrawable = FadingCircle()
        }

        fun RotatingPlane(progressBar: ProgressBar) {
            progressBar.indeterminateDrawable = RotatingPlane()
        }

        fun RotatingCircle(progressBar: ProgressBar) {
            progressBar.indeterminateDrawable = RotatingCircle()
        }

        fun Wave(progressBar: ProgressBar) {
            progressBar.indeterminateDrawable = Wave()
        }

        fun ThreeBounce(progressBar: ProgressBar) {
            progressBar.indeterminateDrawable = ThreeBounce()
        }
    }


}