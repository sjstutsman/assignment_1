package com.csis365.assignment1

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent as Intent


class LoginActivity : AppCompatActivity() {
    private val keyFirstName = "key_first_name"
    private lateinit var btnOne: Button
    private lateinit var pwinput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnOne = findViewById(R.id.btn_one)
        pwinput = findViewById(R.id.pw)

        btnOne.setOnClickListener {
            val listActivityIntent = Intent(this, ListActivity::class.java)
            if (pwinput.text != null){
            startActivity(listActivityIntent)}
        }







        //first parameter is set of keys and values, second is saying values can't be shared
        // key - value pairs
        // "name" - "Greg's native american name"
        val prefs: SharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        //java like
        val editor = prefs.edit()
        editor.putString(keyFirstName, "GregFliesWithGoats").commit()

        //kotlin-y
        with(prefs.edit()){
            putString(keyFirstName, "Gregory")
            commit()
        }



        val prefs2 = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        val firstName = prefs2.getString(keyFirstName, "default value")

        Log.d("asdf", firstName.toString())
    }
}

