package com.kotlin.samples.kotlinapp

import android.app.Application
import com.kotlin.samples.kotlinapp.storage.DbInjector

/**
 * @author : Eduardo Medina
 * @since : 11/13/18
 * @see : https://developer.android.com/index.html
 */
class NoteApp:Application() {

    override fun onCreate() {
        super.onCreate()
        DbInjector.setup(this)
    }
}