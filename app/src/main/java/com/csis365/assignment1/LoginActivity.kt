package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)

        val actionBar = supportActionBar
        actionBar!!.title = "Log In"

        btnLogin.setOnClickListener {

            val UserName = etUsername
            val Password = etPassword

            val welcomeNote = "Welcome + ${UserName.toString()}"

            val intent = Intent(this, FruitActivity::class.java)
        }
    }
}