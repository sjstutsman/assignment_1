package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvFeedback: TextView
    private var noUsername = "no prior login found"
    private var keyUsername = "key_username"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        tvFeedback = findViewById(R.id.tv_feedback)
        btnLogin = findViewById(R.id.btn_login)

        val pastLoginPrefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val pastUsername = pastLoginPrefs.getString(keyUsername, noUsername)
        if(!pastUsername.equals(noUsername)){
            LoginUser(pastUsername)
        }

        btnLogin.setOnClickListener{
            if(etUsername.text.length >= 4 && etPassword.text.toString().equals("password")){

                LoginUser(etUsername.text.toString())
            } else {
                if(etUsername.text.length < 4){
                    tvFeedback.setText(getString(R.string.username_size_error))
                }
                else {
                    tvFeedback.setText(getString(R.string.login_error))
                }
            }
        }
    }

    fun LoginUser(usernameEntered: String?){
        val loginPrefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        with(loginPrefs.edit()){
            putString(keyUsername, usernameEntered)
            commit()
        }
        val intent = Intent(this, FruitListActivity::class.java).apply{
            //putExtra()
        }
        startActivity(intent)
    }


}