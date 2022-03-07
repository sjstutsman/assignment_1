package com.csis365.assignment1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class LoginActivity : AppCompatActivity() {

    private val keyFirstName = "key_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    val prefs : SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    with(prefs.edit())
    {
        putString(keyFirstName, "Andrew")
        commit()
    }

    val prefs2 = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
    val firstName = prefs2.getString(keyFirstName, "default value")

    Log.d("tag", firstName.toString())

}