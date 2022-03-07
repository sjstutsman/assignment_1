package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginButton = findViewById<Button>(R.id.login_btn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)


        //Create a boolean fun, return true if pass and fail if not. Use shared preferences to save login status on close
        loginButton.setOnClickListener {
            if(username.text.length >=(4) && password.text.toString() == "password")
                Log.v("asdf", "Pass")

            else
                Log.v("asdf", "Fail")
        }
    }
}
