package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val keyFirstName = "key_first_name"
    private val keyPassword = "password"
    private lateinit var btnSubmit : Button
    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val prefs: SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        //java like
        val editor = prefs.edit()
        editor.putString(keyFirstName, "Greg").commit()

        //kotlin-y
        //with(prefs.edit()){
        //    putString(keyFirstName, "Gregory")
        //    commit()
        //}


        val firstName = prefs.getString(keyFirstName, "default value")
        btnSubmit = findViewById(R.id.btnSubmit)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)

        btnSubmit.setOnClickListener {
            if(etUsername.text.length > 4 && etPassword.text.toString() == keyPassword){
                val mainActivityIntent = Intent(this,FruitListActivity::class.java)
                startActivity(mainActivityIntent)
            } else {
                alertDialog()
            }
        }

        Log.d("asdf", firstName.toString())


    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Invalid Login Attempt")
        builder.setMessage("Username must be longer than 4 Chars \nPassword must be 'password' ")

        builder.setCancelable(true)

        builder.show()


    }
}