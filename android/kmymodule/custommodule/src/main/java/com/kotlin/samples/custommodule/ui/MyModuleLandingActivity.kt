package com.kotlin.samples.custommodule.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.custommodule.R
import com.kotlin.samples.modules.kcoresupport.ui.BaseActivity

class MyModuleLandingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_module_landing)
        enabledBack()
    }
}
