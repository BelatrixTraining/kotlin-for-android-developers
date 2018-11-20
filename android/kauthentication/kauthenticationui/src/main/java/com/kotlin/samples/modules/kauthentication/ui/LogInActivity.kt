package com.kotlin.samples.modules.kauthentication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.samples.modules.kcoresupport.extensions.goToView
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        ui()
    }

    private fun ui(){
        button.setOnClickListener {
            try {
                goToView(Bundle(),"com.kotlin.samples.modules.kdashboardui.KDashboardActivity")
            }catch (e:Exception){
                Toast.makeText(this@LogInActivity,"exception $e",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
