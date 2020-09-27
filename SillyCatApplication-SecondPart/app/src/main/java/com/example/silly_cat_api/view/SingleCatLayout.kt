package com.example.silly_cat_api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.silly_cat_api.R
import kotlinx.android.synthetic.main.activity_single_cat_layout.*

class SingleCatLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_cat_layout)

        val temperament = intent.getStringExtra("temperament")
        tv_temperament.text = temperament

        val indoor = intent.getStringExtra("indoor")
        tv_indoor.text = indoor

    }
}