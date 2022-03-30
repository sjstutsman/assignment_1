package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {


    private lateinit var name : TextView
    private lateinit var id : TextView
    private lateinit var family : TextView
    private lateinit var genus : TextView
    private lateinit var order : TextView
    private lateinit var carbs : TextView
    private lateinit var protein : TextView
    private lateinit var fat : TextView
    private lateinit var cals : TextView
    private lateinit var sugar : TextView
    private lateinit var backBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        name = findViewById(R.id.fruitname)
        id = findViewById(R.id.fruitid)
        family = findViewById(R.id.fruitfamily)

        genus = findViewById(R.id.fruitgenus)
        order = findViewById(R.id.fruitorder)
        carbs = findViewById(R.id.fruitcarbs)
        protein = findViewById(R.id.fruitprotein)
        fat = findViewById(R.id.fruitfat)
        cals = findViewById(R.id.fruitcals)
        sugar = findViewById(R.id.fruitsugar)

        backBtn = findViewById(R.id.backButton)
        // relates to fruitlistadapter
        val fruitName = intent.extras?.getString("fruitName").toString()
        val fruitService = buildFruitDetail()
        fruitService.getFruitByName(fruitName).enqueue(object : Callback<FruitList> {
            override fun onResponse(call: Call<FruitList>, response: Response<FruitList>) {
                val fruit : FruitList? = response.body()
                Log.i("asdf", fruit.toString())
                if (fruit != null) {
                    name.text = "Name:  "+fruit.name.toString()
                    id.text = "ID:  "+fruit.id.toString()
                    family.text = "Family:  "+fruit.family.toString()
                    genus.text = "Genus:  "+fruit.genus.toString()
                    order.text = "Order:  "+fruit.order.toString()

                    carbs.text = "Carbohydrates: "+fruit.nutritions?.carbohydrates.toString()
                    protein.text = "Protein: "+fruit.nutritions?.protein.toString()
                    fat.text = "Fat: "+fruit.nutritions?.fat.toString()
                    cals.text = "Calories: "+fruit.nutritions?.calories.toString()
                    sugar.text = "Sugar: "+fruit.nutritions?.sugar.toString()
                }

            }

            override fun onFailure(call: Call<FruitList>, t: Throwable) {
                Log.i("asdf", "failure")
            }

        })


        backBtn.setOnClickListener {

            this.finish()
        }


    }


    private fun buildFruitDetail(): FruitListService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitListService::class.java)
    }
}