package com.example.test.model

import android.widget.EditText
import android.widget.TextView

data class PrescriptionLayout(
    var drugRank: TextView,
    var name: EditText,
    var number: EditText,
    var type: EditText,
    var use: EditText,
)
