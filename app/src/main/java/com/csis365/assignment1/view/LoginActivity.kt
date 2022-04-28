package com.csis365.assignment1.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.csis365.assignment1.R

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var cbSaveLogin: CheckBox
    private lateinit var sharedPreferences: SharedPreferences


    private val MIN_USERNAME_LENGTH = 4
    private val REQUIRED_PASSWORD = "PASSWORD"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val actionBar = supportActionBar
        actionBar!!.title = "Log In"
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        btnLogin = findViewById(R.id.btn_login)
        cbSaveLogin = findViewById(R.id.save_login)


        sharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val getUsername = sharedPreferences.getString("strUserName","username")
        val getPassword = sharedPreferences.getString("strPassword","password")
        etUsername.setText(getUsername.toString())
        etPassword.setText(getPassword.toString())



        btnLogin.setOnClickListener {
            if (validateUserName()){

                if (cbSaveLogin.isChecked){
                    val editor = sharedPreferences.edit()
                    editor.putString("strUserName", etUsername.text.toString()).apply()
                    editor.putString("strPassword", etPassword.text.toString()).apply()


                    val intent = Intent(this, FruitListActivity::class.java)
                    Toast.makeText(this,"  username Saved ",Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                } else{
                    val editor = sharedPreferences.edit()
                    editor.putString("strUserName", "").apply()
                    editor.putString("strPassword", "").apply()

                    val intent = Intent(this, FruitListActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
    // validating the userName
    private fun validateUserName(): Boolean{
        if (etUsername.length() < MIN_USERNAME_LENGTH){
            etUsername.error = "!Error -- more than 4 characters!"

            return false
        }
        if (etPassword.text.toString() != REQUIRED_PASSWORD.lowercase()){
            etPassword.error = "!Error -- password has to be password!"
            return false
        }
        return true
    }


}