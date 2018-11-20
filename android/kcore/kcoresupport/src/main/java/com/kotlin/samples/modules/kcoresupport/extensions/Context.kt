package com.kotlin.samples.modules.kcoresupport.extensions

import android.content.Context
import android.content.Intent
import android.os.Bundle

@Throws(Exception::class)
fun Context.goToView(bundle:Bundle?,viewName:String?){
    val intent:Intent= Intent()

    viewName?.let {
        intent.setClassName(this,it)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}