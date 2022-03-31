package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val keyAuthorization = "key_authorization"
    private val keyPassword = "key_password"
    private lateinit var loginSubmit : Button
    private lateinit var loginPassword : EditText
    private lateinit var loginUsername : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = Intent(this@LoginActivity, ListFruitActivity::class.java)
        val prefs : SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val editor  = prefs.edit()
        if(prefs.getBoolean(keyAuthorization, false)) {
            startActivity(intent)
        } else {
            editor.putBoolean(keyAuthorization, false).commit()
        }
        editor.putString(keyPassword, "password").commit()

        loginSubmit = findViewById(R.id.login_submit)
        loginUsername = findViewById(R.id.login_username)
        loginPassword = findViewById(R.id.login_password)

        loginSubmit.setOnClickListener {
            val prefs = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
            val password = prefs.getString(keyPassword, "default value")
            if (loginPassword.text.toString() == password && loginUsername.text.isNotEmpty()) {
                val editor = prefs.edit()
                editor.putBoolean(keyAuthorization, true).commit()
                startActivity(intent)
            }
        }
    }
}