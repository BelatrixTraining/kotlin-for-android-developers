package com.belatrixsf.nullsafetyandroidexample.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.belatrixsf.nullsafetyandroidexample.R

/**
 * @author Luis Alonso Paulino Flores
 *
 */

class ExampleActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_example)

        val username = intent.extras[Constants.ARG_USERNAME] as String

        supportFragmentManager.findFragmentById(R.id.exampleFrameLayout) ?: ExampleFragment.newInstance(username).also {
            supportFragmentManager.beginTransaction().replace(R.id.exampleFrameLayout, it).commit()
        }
    }
}