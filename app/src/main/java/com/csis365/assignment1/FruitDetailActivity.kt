package com.csis365.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import org.w3c.dom.Text

class FruitDetailActivity : AppCompatActivity() {
    private lateinit var fruitId: TextView
    private lateinit var name: TextView
    private lateinit var family: TextView
    private lateinit var genus: TextView
    private lateinit var calorie: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_detail)
        val fruit = intent.extras?.get("fruit") as Fruity

        val toolbar: MaterialToolbar = findViewById(R.id.titleBar)
        val name: TextView = findViewById(R.id.name)
        val family: TextView = findViewById(R.id.family)
        val genus: TextView = findViewById(R.id.genus)
        val order: TextView = findViewById(R.id.order)
        val calorie: TextView = findViewById(R.id.calorie)
        val sugar: TextView = findViewById(R.id.sugar)
        val protein: TextView = findViewById(R.id.protein)
        val carb: TextView = findViewById(R.id.carbohydrate)

        toolbar.title = fruit.name
        name.text = fruit.name
        family.text = "Family: " + fruit.family
        genus.text = "Genus: "+ fruit.genus
        order.text = "Order: " + fruit.order
        calorie.text = "Calorie: " + fruit.nutritions.calories.toString()
        sugar.text = "Sugar: " + fruit.nutritions.sugar.toString()
        protein.text = "Protien: "+ fruit.nutritions.protein.toString()
        carb.text = "Carbohydrates: " + fruit.nutritions.carbohydrates.toString()

    }
}