package com.csis365.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.properties.Delegates

private lateinit var fruitName:TextView
private lateinit var fruitFamily:TextView
private lateinit var fruitGenus:TextView
private lateinit var fruitOrder:TextView
private lateinit var fruitCarbohydrates:TextView
private lateinit var fruitProtein:TextView
private lateinit var fruitFat:TextView
private lateinit var fruitCalories:TextView
private lateinit var fruitSugar:TextView
private lateinit var fruitBack:Button

class FruitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit)

        fruitName = findViewById(R.id.fruit_name)
        fruitFamily = findViewById(R.id.fruit_family)
        fruitGenus = findViewById(R.id.fruit_genus)
        fruitOrder = findViewById(R.id.fruit_order)
        fruitCarbohydrates = findViewById(R.id.fruit_carbohydrates)
        fruitProtein = findViewById(R.id.fruit_protein)
        fruitFat = findViewById(R.id.fruit_fat)
        fruitCalories = findViewById(R.id.fruit_calories)
        fruitSugar = findViewById(R.id.fruit_sugar)
        fruitBack = findViewById(R.id.fruit_back)

        fruitBack.setOnClickListener{
            finish()
        }

        val fruitbundle = intent.extras?.getBundle("fruit")

        fruitName.setText(fruitbundle?.getString("name"))
        fruitFamily.setText(fruitbundle?.getString("family"))
        fruitGenus.setText(fruitbundle?.getString("genus"))
        fruitOrder.setText(fruitbundle?.getString("order"))
        fruitCarbohydrates.setText(fruitbundle?.getInt("carbohydrates").toString())
        fruitFat.setText(fruitbundle?.getInt("fat").toString())
        fruitSugar.setText(fruitbundle?.getInt("sugar").toString())



    }
}