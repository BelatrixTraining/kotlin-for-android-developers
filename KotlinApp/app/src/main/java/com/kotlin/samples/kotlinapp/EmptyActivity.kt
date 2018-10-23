package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : AppCompatActivity() {

    companion object {
        val TAG:String="EmptyActivity"
    }
    //private lateinit var imageView:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        imageView.setOnClickListener {
            showMessage("Hello Kotlin!")
        }
    }

    private fun showMessage(message:String?){
        Log.v(TAG, "message : $message")
        Toast.makeText(this,"message : $message", Toast.LENGTH_SHORT ).show()
    }
}
