package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kotlin.samples.kotlinapp.fragments.MinionListFragment

class MinionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minion)

        if(savedInstanceState==null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.container,MinionListFragment.newInstance("",""))
                    .commit()
        }
    }
}
