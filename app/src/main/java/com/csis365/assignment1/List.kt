package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter)
        title ="Fruit List"
    }
}