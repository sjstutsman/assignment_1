package com.csis365.assignment1

import android.content.Context
import android.util.Log
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private val keyFirstName = "key_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    val prefs : SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    val editor : SharedPreferences.Editor = prefs.edit()
    editor.putString(keyFirstName, "Andrew").commit()


    val prefs2 = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    val firstName = prefs2.getString(keyFirstName, "default value")

    Log.i("tag", firstName)

}