package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.util.Objects.toString

class DetailsPage : AppCompatActivity() {

    private lateinit var details: TextView
    private lateinit var nutrition_detail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_page)

        details = findViewById<TextView>(R.id.details)
        nutrition_detail = findViewById<TextView>(R.id.nutrition_detail)

        var fruit = intent.extras?.get("fruit") as Fruit

        var list = arrayOf(fruit)
        for (item in list) {
            details.append("genus: " + item.genus + "\n" + "family: " + item.family + "\n" + "order: " + item.order + "\n")
            nutrition_detail.append(
                "Carbohydrate: " + item.nutritions.carbohydrates + "\n" + "Protein: " + item.nutritions.protein + "\n"
                        + "Calories: " + item.nutritions.calories + "\n" + "Fat: " + item.nutritions.fat + "\n" + "Sugar: " + item.nutritions.sugar + "\n"
            )
        }





        Log.d("fruit", fruit.toString())


    }
}