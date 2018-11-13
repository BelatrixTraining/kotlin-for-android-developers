package com.kotlin.samples.kotlinapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.extensions.toast
import kotlinx.android.synthetic.main.activity_empty2.*

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty2)

        button.setOnClickListener {
            toast("Hello kotlin! ")
        }
        //supportFragmentManager
    }
}
