package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.csis365.assignment1.service.FruitService
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.Path

class FruitDetail : AppCompatActivity() {
    private lateinit var name: TextView
    private lateinit var genus: TextView
    private lateinit var order: TextView
    private lateinit var id: TextView
    private lateinit var family: TextView
    private lateinit var nutritions: TextView
    private val key_fruit = "key_fruit"
    private val key_id = "key_id"

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

        val serializedFruit = getIntent().getSerializableExtra(key_fruit)
        val fruitId = getIntent().getIntExtra(key_id,3)

        // handling fruit list
        val fruitService = buildService()
        fruitService.getFruit(fruitId).enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.d("asdf","onResponse()")

                val bundle : Bundle? = intent.extras
                val tmpName = bundle!!.getString("Name")
                val tmpGenus = bundle.getString("Genus")
                val tmpOrder = bundle.getString("Order")
                val tmpId = bundle.getString("Id")
                val tmpFamily = bundle.getString("Family")
                val tmpNutritions = bundle.getString("Nutritions")

                name.text = tmpName
                genus.text = tmpGenus
                order.text = tmpOrder
                id.text = tmpId
                family.text = tmpFamily
                nutritions.text = tmpNutritions



            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.v("asdf", "onFailure()")
            }
        }

        )

    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(FruitService::class.java)
    }

}