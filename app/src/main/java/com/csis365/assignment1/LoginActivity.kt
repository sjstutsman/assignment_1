package com.csis365.assignment1

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

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var cbSaveLogin: CheckBox
    private lateinit var sharedPreferences: SharedPreferences


    val MIN_USERNAME_LENGTH = 4
    val REQUIRED_PASSWORD = "PASSWORD"

    private lateinit var prefs: SharedPreferences
//        getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

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

                val UserName = etUsername!!.text.toString()
                val Password = etPassword!!.text.toString()


//                val editor: SharedPreferences.Editor = prefs.edit()
//                editor.putString("USERNAME", UserName).commit()
//                editor.putString("Password", Password).commit()

                if (cbSaveLogin.isChecked()){
                    val editor: SharedPreferences.Editor = prefs.edit()
                    editor.putString(getString(R.string.checkbox), "True").apply()
                    editor.putString("USERNAME", UserName).commit()
                    editor.putString("Password", Password).commit()

                    val name = prefs.getString("nam",UserName)!!
                    val pass = prefs.getString("pswd",Password)!!
                    val intent = Intent(this, FruitListActivity::class.java)
                    Toast.makeText(this,name + " okSaved " + pass,Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                } else{
                    val editor: SharedPreferences.Editor = prefs.edit()
                    editor.putString(getString(R.string.checkbox), "False").commit()
                    editor.putString("USERNAME", "").commit()
                    editor.putString("Password", "").commit()

                    val intent = Intent(this, FruitListActivity::class.java)
                    startActivity(intent)
                }

                /*
                val name = prefs.getString("nam",UserName)!!
                val pass = prefs.getString("pswd",Password)!!

                val intent = Intent(this, FruitActivity::class.java)

                Toast.makeText(this,name + " okSaved " + pass,Toast.LENGTH_SHORT).show()

                startActivity(intent)
                */


            }
        }
    }
    // validating the userName
    fun validateUserName(): Boolean{
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

        /*
        strCheckBox = sharedPreferences.getString(getString(R.string.checkBox), "False").toString()
        strName = sharedPreferences.getString(getString(R.string.name), "").toString()
        strPassword = sharedPreferences.getString(getString(R.string.password), "").toString()
        name.setText(strName)
        password.setText(strPassword)
        checkBox.isChecked = strCheckBox == "True"
        //val CHECKBOX = cbSaveLogin!!.text.toString()

//        val editor: SharedPreferences.Editor = prefs.edit()
//        editor.putString("USERNAME", user).commit()
//        editor.putString("Password", pass).commit()
//        editor.putString("USERNAME", UserName).commit()
//        editor.putString("Password", Password).commit()

        val name = prefs.getString("nam",UserName)
        val pass = prefs.getString("pswd",Password)

        Toast.makeText(this,name + " okSaved " + pass,Toast.LENGTH_SHORT).show()
        */


    }


}