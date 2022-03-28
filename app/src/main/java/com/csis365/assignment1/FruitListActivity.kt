package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.service.FruitService
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitListActivity : AppCompatActivity() {

    private var fruitList: List<Fruit>? = null
    private val fruitService = buildService()
    private lateinit var rvFruitList : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruitList = findViewById(R.id.rv_fruitList)
        rvFruitList.layoutManager = LinearLayoutManager(this)

        fruitService.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                //Log.i("asdf",response.body().toString())
                fruitList = response.body()
                rvFruitList.adapter = FruitListAdapter(fruitList)
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
               // Log.e("asdf","onFailure()")
                rvFruitList.adapter = FruitListAdapter(null)
            }
        })


    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)
    }
}