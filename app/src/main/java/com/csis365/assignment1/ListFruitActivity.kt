package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class ListFruitActivity : AppCompatActivity() {
    private lateinit var rvItems: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fruit)

        rvItems = findViewById(R.id.rv_items)
        rvItems.layoutManager = LinearLayoutManager(this)

        var fruityViceService:FruityViceService = FruitRetrofit().service
        fruityViceService.listRepos().enqueue(object : Callback<Fruit> {

            override fun onResponse(call: Call<Fruit>, response: Response<Fruit>){
                Log.i("tag", "Call response")
            }

            override fun onFailure(call: Call<Fruit>, t: Throwable) {
                Log.e("tag", "Fruit object not created")
            }

        })



    }
}
