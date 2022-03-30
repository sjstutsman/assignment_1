package com.csis365.assignment1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.csis365.assignment1.Services.Fruits
import com.google.gson.Gson

class Details : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Realized after I finished this that I should've just send the ID and used the api to get
        // the info, but instead I sent everything through the intent. Hopefully that is okay.

        val carbTV: TextView = findViewById(R.id.carbohydrates)
        val proteinTV: TextView = findViewById(R.id.protein)
        val fatTV: TextView = findViewById(R.id.fat)
        val calTV: TextView = findViewById(R.id.calories)
        val sugarTV: TextView = findViewById(R.id.sugar)

        val name = intent.getSerializableExtra("name")
        val carbohydrates = intent.getSerializableExtra("carb")
        val protein = intent.getSerializableExtra("protein")
        val fat = intent.getSerializableExtra("fat")
        val calories = intent.getSerializableExtra("cal")
        val sugar = intent.getSerializableExtra("sugar")

        // Setting the textviews and title to match the chosen fruit's contents
        title = "${name}'s Details"
        carbTV.text = "Carbohydrates: ${carbohydrates}"
        proteinTV.text = "Protein: ${protein}"
        fatTV.text = "Fat: ${fat}"
        calTV.text = "Calories: ${calories}"
        sugarTV.text = "Sugar: ${sugar}"
    }
}