package com.kotlin.samples.modules.kdashboardui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.kotlin.samples.modules.kcoresupport.extensions.goToView
import kotlinx.android.synthetic.main.activity_kdashboard.*
import com.kotlin.samples.modules.kdashboardui.R
import java.lang.Exception

//com.kotlin.samples.modules.kdashboardui.KDashboard
class KDashboard:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kdashboard)
        ui()
    }

    private fun ui(){
        buttonFNote.setOnClickListener {
            try {
                goToView( Bundle(),"com.kotlin.samples.modules.knotes.ui.NotesLandingActivity")
            }catch (e:Exception){
                showMessage(e.message)
            }

        }

        buttonFA.setOnClickListener {
            try {
                goToView( Bundle(),"com.kotlin.samples.modules.knotes.ui.FALandingActivity")
            }catch (e:Exception){
                showMessage(e.message)
            }

        }

        buttonFB.setOnClickListener {
            try {
                goToView( Bundle(),"com.kotlin.samples.modules.knotes.ui.FBLandingActivity")
            }catch (e:Exception){
                showMessage(e.message)
            }

        }
    }

    private fun showMessage(message:String?){
        Toast.makeText(this, ": $message",Toast.LENGTH_LONG).show()
    }

}