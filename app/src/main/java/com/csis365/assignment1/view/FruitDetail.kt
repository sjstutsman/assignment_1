package com.csis365.assignment1.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.csis365.assignment1.R
import com.csis365.assignment1.service.FruitService
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitDetail : AppCompatActivity() {
    private lateinit var name: TextView
    private lateinit var genus: TextView
    private lateinit var order: TextView
    private lateinit var id: TextView
    private lateinit var family: TextView
    private lateinit var nutritions: TextView
    private lateinit var carbohydrates : TextView
    private lateinit var protein : TextView
    private lateinit var fat : TextView
    private lateinit var calories : TextView
    private lateinit var sugar : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_detail)

        val actionBar = supportActionBar
        actionBar!!.title = "Fruit Detail"
        actionBar.setDisplayHomeAsUpEnabled(true)   // show back button in action bar

        name = findViewById(R.id.tv_name)
        genus = findViewById(R.id.tv_genus)
        order = findViewById(R.id.tv_order)
        id = findViewById(R.id.tv_id)
        family = findViewById(R.id.tv_family)
        nutritions = findViewById(R.id.tv_nutritions)

        carbohydrates = findViewById(R.id.tv_carbohydrates)
        protein = findViewById(R.id.tv_protein)
        fat = findViewById(R.id.tv_fat)
        calories = findViewById(R.id.tv_calories)
        sugar = findViewById(R.id.tv_sugar)



        val intent = intent

        val tmpName = intent.getStringExtra("Name")
        val tmpGenus = intent.getStringExtra("Genus")
        val tmpOrder = intent.getStringExtra("Order")
        val tmpId = intent.getIntExtra("Id", -1)
        val tmpFamily = intent.getStringExtra("Family")


        val tmpCarbohydrate = intent.getDoubleExtra("Carbohydrates", -1.0)
        val tmpProtein = intent.getDoubleExtra("Protein", -1.0)
        val tmpFat = intent.getDoubleExtra("Fat",-1.0)
        val tmpCalories = intent.getIntExtra("Calories", -1)
        val tmpSugar = intent.getDoubleExtra("Sugar", -1.0)


        // handling fruit list
        val fruitService = buildService()
        fruitService.getFruit(0).enqueue(object : Callback<List<Fruit>> {
            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.d("asdf","onResponse()")

                name.text = tmpName
                genus.text = "Genus: $tmpGenus"
                order.text = "Order: $tmpOrder"
                id.text = "Id: $tmpId"
                family.text = "Family: $tmpFamily"
                nutritions.text = "Nutritions"

                carbohydrates.text = "Carbohydrates: $tmpCarbohydrate"
                protein.text = "Protein: $tmpProtein"
                fat.text = "Fat: $tmpFat"
                calories.text = "Calories: $tmpCalories"
                sugar.text = "Sugar: $tmpSugar"

            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.v("asdf", "onFailure()")
            }
        })
    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(FruitService::class.java)
    }

}