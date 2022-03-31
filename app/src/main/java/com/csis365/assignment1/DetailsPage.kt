package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class DetailsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        var fruit = intent.extras?.get("fruit") as Fruit

        Log.d("fruit", fruit.toString())

    }
}