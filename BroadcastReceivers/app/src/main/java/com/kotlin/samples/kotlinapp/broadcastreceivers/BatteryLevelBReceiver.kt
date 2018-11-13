package com.kotlin.samples.kotlinapp.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class BatteryLevelBReceiver:BroadcastReceiver() {

    private var callback: BatteryLevelCallback? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        val level = intent?.getIntExtra("level", 0)

        Log.v("CONSOLE", "level $level")

        callback?.onLevel(level)

    }

    fun registerCallback(mCallback: BatteryLevelCallback) {
        callback = mCallback
    }

    fun unRegisterCallback() {
       callback = null
    }

    interface BatteryLevelCallback{
        fun onLevel(level:Int?)
    }
}