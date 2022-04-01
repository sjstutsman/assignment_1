package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.color.DynamicColors

class MainActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var login: Button
    var hasAccount = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.id_username)
        password = findViewById(R.id.id_password)
        login = findViewById(R.id.id_login)


        sharedPref = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        hasAccount = sharedPref.getBoolean("hasAccount", false)

        if (hasAccount) goToHome()

        login.setOnClickListener {
            handleLogin(username.text.toString(), password.text.toString())
        }
    }
    private fun goToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun handleLogin (name: String, pass: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        if (name.length < 4 && pass != "password") {
            Toast.makeText(this, "Error Logging In", Toast.LENGTH_LONG).show()
            return
        }
        editor.putString("username", name)
        editor.putBoolean("hasAccount", true)
        editor.apply()
        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
        goToHome()
    }
}