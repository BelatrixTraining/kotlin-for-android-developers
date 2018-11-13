package com.kotlin.samples.kotlinapp

import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.Toast
import com.kotlin.samples.kotlinapp.broadcastreceivers.BatteryLevelBReceiver
import com.kotlin.samples.kotlinapp.extensions.toast
import com.kotlin.samples.kotlinapp.view.BoxView
import kotlinx.android.synthetic.main.activity_main.*



/**
 * Broadcast Receivers
 * 1. Registrar broadcast receiver en AndroidManifest
 * 2. Declarar broadcast customizado o usar uno por default
 * 3. Invocarlo en el activity o fragment.
 *
 * https://developer.android.com/reference/android/content/Intent
 * Intent.ACTION_BATTERY_CHANGED
 * Intent.ACTION_BOOT_COMPLETED
 * Intent.ACTION_POWER_CONNECTED
 * Intent.ACTION_POWER_DISCONNECTED
 * Intent.ACTION_BATTERY_LOW
 * Intent.ACTION_BATTERY_OKAY
 */
class MainActivity : AppCompatActivity(),BatteryLevelBReceiver.BatteryLevelCallback {

    private lateinit var boxView: BoxView
    private var batteryLevelBReceiver:BatteryLevelBReceiver?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ui
        val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT)
        layoutParams.gravity= Gravity.CENTER

        boxView= BoxView(this)
        boxView.setBackgroundColor(Color.WHITE)
        boxView.layoutParams=layoutParams

        frameLayoutContainer.addView(boxView)

        //broadcastreceiver
        batteryLevelBReceiver= BatteryLevelBReceiver()
    }


    override fun onStart() {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryLevelBReceiver, intentFilter)
        batteryLevelBReceiver?.registerCallback(this)
        super.onStart()
    }

    override fun onStop() {
        batteryLevelBReceiver?.let {
            it.unRegisterCallback()
            unregisterReceiver(it)
        }
        super.onStop()
    }

    override fun onLevel(level: Int?) {
        toast("level $level", Toast.LENGTH_SHORT)
        Log.v("CONSOLE","level $level")

        boxView.updateView(level?:0)
    }

}
