package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Login Page"

        val loginButton = findViewById<Button>(R.id.login_btn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        loginButton.setOnClickListener {
            if(username.text.length >=(4) && password.text.toString() == "password") {
                startActivity(Intent(this, List::class.java))
            }
            else
                Toast.makeText(applicationContext, "Login failed, please try again!", Toast.LENGTH_SHORT).show()
        }
    }
}
