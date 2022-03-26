package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        title ="Details"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra("id", 0)
        Log.d("asdf", id.toString())


    }
}