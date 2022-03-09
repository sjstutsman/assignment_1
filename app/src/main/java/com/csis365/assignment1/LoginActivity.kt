package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvFeedback: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        tvFeedback = findViewById(R.id.tv_feedback)
        btnLogin = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            if(etUsername.text.length >= 4 && etPassword.equals("password")){
                //pass to fruit list activity
            } else {
                if(etUsername.text.length < 4){
                    tvFeedback.setText("Error: minimum username length is 4 characters")
                }
                else {
                    tvFeedback.setText("Error: username or password incorrect")
                }
            }
        }
    }


}