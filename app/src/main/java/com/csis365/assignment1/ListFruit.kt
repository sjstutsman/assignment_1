package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.Services.Adapter
import com.csis365.assignment1.Services.FruitService
import com.csis365.assignment1.Services.Fruits
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListFruit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        title = "Fruit List"

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(FruitService::class.java)

        api.getFruit().enqueue(object : Callback<List<Fruits>> {
            override fun onResponse(call: Call<List<Fruits>>, response: Response<List<Fruits>>) {
                showData(response.body()!!)
            }
            override fun onFailure(call: Call<List<Fruits>>, t: Throwable) {
                Log.d("asdf", "onFailure")
            }
        })
    }

        private fun showData(fruits: List<Fruits>) {
            val rv: RecyclerView= findViewById(R.id.recyclerView)
            rv.layoutManager = LinearLayoutManager(this@ListFruit)
            val adapter = Adapter(fruits)
            rv.adapter = adapter
            adapter.setOnItemClickListener(object : Adapter.onItemClickListener{
                override fun onItemClick(position: Int) {
                    val myIntent = Intent(this@ListFruit, Details::class.java)
                    myIntent.putExtra("name","${fruits[position].name}")
                    myIntent.putExtra("carb","${fruits[position].nutritions.carbohydrates}")
                    myIntent.putExtra("protein","${fruits[position].nutritions.protein}")
                    myIntent.putExtra("fat","${fruits[position].nutritions.fat}")
                    myIntent.putExtra("cal","${fruits[position].nutritions.calories}")
                    myIntent.putExtra("sugar","${fruits[position].nutritions.sugar}")
                    startActivity(myIntent)
                }
            })
        }
}