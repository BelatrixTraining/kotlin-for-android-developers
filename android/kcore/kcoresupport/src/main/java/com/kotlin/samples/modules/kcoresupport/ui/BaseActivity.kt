package com.kotlin.samples.modules.kcoresupport.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.modules.kcoresupport.R

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    protected fun enabledBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
