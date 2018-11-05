package com.belatrixsf.nullsafetyandroidexample.presentation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.belatrixsf.nullsafetyandroidexample.R

/**
 * @author Luis Alonso Paulino Flores
 *
 */

class LogInActivity: AppCompatActivity() {

    lateinit var usernameEditText: EditText
    lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_log_in)

        usernameEditText = findViewById(R.id.usernameEditText)
        continueButton = findViewById(R.id.continueButton)

        continueButton.setOnClickListener {
            val username = usernameEditText.text

            if (username.isNotEmpty() && username.isNotBlank()) {
                Intent(this@LogInActivity, ExampleActivity::class.java).apply {
                    putExtra(Constants.ARG_USERNAME, username)
                }.let {
                    startActivity(it)
                }
            } else {
                Toast.makeText(this@LogInActivity, "Invalid username!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}