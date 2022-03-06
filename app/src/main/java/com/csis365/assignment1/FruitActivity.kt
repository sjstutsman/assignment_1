package com.csis365.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class FruitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)


        val actionBar = supportActionBar
        actionBar!!.title = "Fruit Activity"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }


}