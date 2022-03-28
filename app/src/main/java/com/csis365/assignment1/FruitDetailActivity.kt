package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.csis365.assignment1.service.FruitService
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitDetailActivity : AppCompatActivity() {

    private lateinit var tvName : TextView
    private lateinit var tvOrder : TextView
    private lateinit var tvFamily : TextView
    private lateinit var tvGenus: TextView
    private lateinit var tvCarbs : TextView
    private lateinit var tvProtein: TextView
    private lateinit var tvFat : TextView
    private lateinit var tvCal: TextView
    private lateinit var tvSugar: TextView

    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fruitdetail_activity)

        tvName = findViewById(R.id.tv_FruitDetailName)
        tvOrder = findViewById(R.id.tv_order)
        tvFamily = findViewById(R.id.tv_family)
        tvGenus = findViewById(R.id.tv_genus)
        tvCarbs = findViewById(R.id.tv_carbs)
        tvProtein = findViewById(R.id.tv_protein)
        tvFat = findViewById(R.id.tv_fat)
        tvCal = findViewById(R.id.tv_calories)
        tvSugar = findViewById(R.id.tv_sugar)

        btnBack = findViewById(R.id.btn_back)

        val fruitName = intent.extras?.getString("fruitName").toString()
        val fruitService = buildService()

        fruitService.getFruitByName(fruitName).enqueue(object : Callback<Fruit> {
            override fun onResponse(call: Call<Fruit>, response: Response<Fruit>) {
                //Log.i("asdf",response.body().toString())
                val fruit : Fruit? = response.body()
                if (fruit != null) {
                    tvName.text = fruit.name.toString()
                    tvOrder.text = "Order : " + fruit.order.toString()
                    tvFamily.text = "Family : " + fruit.family.toString()
                    tvGenus.text = "Genus : " + fruit.genus.toString()
                    tvCarbs.text = "Carbs: " + fruit.nutritions?.carbohydrates.toString()
                    tvProtein.text = "Protein : " + fruit.nutritions?.protein.toString()
                    tvFat.text = "Fat : " + fruit.nutritions?.fat.toString()
                    tvCal.text = "Calories : " + fruit.nutritions?.calories.toString()
                    tvSugar.text = "Sugar : " + fruit.nutritions?.sugar.toString()
                } else{
                    Log.e("asdf","no Fruit to detail")
                }
            }

            override fun onFailure(call: Call<Fruit>, t: Throwable) {
                Log.e("asdf","onFailure()")
            }
        })

        btnBack.setOnClickListener {
            this.finish()
        }
        }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)
    }

    }

