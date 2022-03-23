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

class FruitDetailActivity : AppCompatActivity() {
    private lateinit var rvFruitDetail: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruitDetail = findViewById(R.id.rv_fruit_detail)
        rvFruitDetail.layoutManager = LinearLayoutManager(this)

        val fruitService = buildService()
        fruitService.getFruitAll().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.i("asdf", "onResponse()")
            }
            override fun onFailure(call: Call<List<Fruit>>, t: Throwable){
                Log.i("asdf", "FruitAPI call failed")
            }
        })
        rvFruitDetail.adapter = FruitDetailAdapter(
            fruitService.getFruitAll()
        )

    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fruityvice.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)
    }
}