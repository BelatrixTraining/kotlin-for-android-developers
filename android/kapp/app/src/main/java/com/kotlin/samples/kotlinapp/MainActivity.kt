package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.samples.modules.kcoresupport.extensions.goToView
import java.util.*

class MainActivity : AppCompatActivity() {

    private val SPLASH_SCREEN_DELAY: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
    }

    private fun ui(){
        val task = object :TimerTask(){
            override fun run() {
                goToView(Bundle(),"com.kotlin.samples.modules.kdashboardui.KDashboard")
            }
        }

        val timer = Timer()
        timer.schedule(task, SPLASH_SCREEN_DELAY)
    }
}
