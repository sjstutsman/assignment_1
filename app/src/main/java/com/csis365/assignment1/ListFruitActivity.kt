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


        val fruityViceService:FruityViceService = FruitRetrofit().service
        val call : Call<List<Fruit>> = fruityViceService.listRepos()
        call.enqueue(object : Callback<List<Fruit>> {

            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>){
                Log.i("tag", "Call response")
                rvItems.adapter = MyItemAdapter(response.body().orEmpty())
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.e("tag", "Fruit object not created")
                val failList: MutableList<Fruit> = mutableListOf()
                val failFruit = Fruit(name = "fail", family = null, genus = null, id = null, nutritions = null, order = null)
                failList.add(failFruit)
                rvItems.adapter = MyItemAdapter(failList)
            }

        })







    }
}
