package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText

class MainActivity : AppCompatActivity() {
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var login_btn : Button
    private lateinit var SharedPreferences : SharedPreferences
    private var loggedIn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SharedPreferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE)
        loggedIn = SharedPreferences.getBoolean("LOGGEDIN", false)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        login_btn = findViewById(R.id.login_btn)


        login_btn.setOnClickListener{

            if(username.text.toString().length > 0 && password.text.toString() == "password")
            {
                val edit : SharedPreferences.Editor = SharedPreferences.edit()

                edit.putString("USERNAME", username.text.toString())
                edit.putBoolean("LOGGEDIN", true)
                edit.apply()

                var intent = Intent(this, FruitHome::class.java)
                startActivity(intent)

                Toast.makeText(this, "Loggedin Succesfully", LENGTH_SHORT).show()
            }
            else {
               Toast.makeText(this, "INVALID LOGIN", LENGTH_SHORT).show()
            }
        }


    }
}