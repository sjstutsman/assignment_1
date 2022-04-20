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


        val prefs: SharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        checkSP()
        btnLogin.setOnClickListener {
            if (validateUserName()){

                val userName = etUsername.text.toString()
                val password = etPassword.text.toString()


                if (cbSaveLogin.isChecked){
                    val editor: SharedPreferences.Editor = prefs.edit()
                    editor.putString(getString(R.string.checkbox), "True").apply()
                    editor.putString("USERNAME", userName).apply()
                    editor.putString("Password", password).apply()

                    val intent = Intent(this, FruitListActivity::class.java)
                    Toast.makeText(this,"  username Saved ",Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                } else{
                    val editor: SharedPreferences.Editor = prefs.edit()
                    editor.putString(getString(R.string.checkbox), "False").apply()
                    editor.putString("USERNAME", "").apply()
                    editor.putString("Password", "").apply()

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

    private fun checkSP() {
        val strCheckBox = sharedPreferences.getString(getString(R.string.checkbox), "False").toString()
        val strName = sharedPreferences.getString(getString(R.string.username), "").toString()
        val strPassword = sharedPreferences.getString(getString(R.string.password), "").toString()
        etUsername.setText(strName)
        etPassword.setText(strPassword)
        cbSaveLogin.isChecked = strCheckBox == "True"
    }


}