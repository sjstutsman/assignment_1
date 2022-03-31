package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Name: Jared Lanoue
// My assignment definitely doesn't follow the ideal code organization and is a bit messy, but it
// all works perfectly and should have all of the requirements for this assignment.

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Fruityvice Login Page"
        val loginButton = findViewById<Button>(R.id.login_btn)
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val pref = getSharedPreferences("loginState", Context.MODE_PRIVATE)
        val loginError = findViewById<TextView>(R.id.error_message)

        fun validateLogin(username: EditText, password: EditText) {
            loginButton.setOnClickListener {
                if (username.text.length >= (4) && password.text.toString() == "password") {
                    with(pref.edit()){
                    putBoolean("loginState", true)
                    commit()
                    }
                    startActivity(Intent(this, ListFruit::class.java))
                } else {
                    loginError.visibility = View.VISIBLE
                }
            }
        }

        fun checkLogin(pref: SharedPreferences, username: EditText, password: EditText) {
            if (pref.getBoolean("loginState", true)) {
                startActivity(Intent(this, ListFruit::class.java))
            } else {
                validateLogin(username, password)
            }
        }

        checkLogin(pref, username, password)

    }
}
