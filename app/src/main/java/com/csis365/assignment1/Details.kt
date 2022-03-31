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

        val carbTV: TextView = findViewById(R.id.carbohydrates)
        val proteinTV: TextView = findViewById(R.id.protein)
        val fatTV: TextView = findViewById(R.id.fat)
        val calTV: TextView = findViewById(R.id.calories)
        val sugarTV: TextView = findViewById(R.id.sugar)
        val genusTV: TextView = findViewById(R.id.genus)
        val familyTV: TextView = findViewById(R.id.family)
        val orderTV: TextView = findViewById(R.id.order)

        val name = intent.getSerializableExtra("name")
        val carbohydrates = intent.getSerializableExtra("carb")
        val protein = intent.getSerializableExtra("protein")
        val fat = intent.getSerializableExtra("fat")
        val calories = intent.getSerializableExtra("cal")
        val sugar = intent.getSerializableExtra("sugar")
        val genus = intent.getSerializableExtra("genus")
        val family = intent.getSerializableExtra("family")
        val order = intent.getSerializableExtra("order")

        // Setting the textviews and title to match the chosen fruit's contents

        title = "${name}'s Details"

        genusTV.text = "Genus: $genus"
        familyTV.text = "Family: $family"
        orderTV.text = "Order: $order"

        carbTV.text = "Carbohydrates: $carbohydrates"
        proteinTV.text = "Protein: $protein"
        fatTV.text = "Fat: $fat"
        calTV.text = "Calories: $calories"
        sugarTV.text = "Sugar: $sugar"


    }
}