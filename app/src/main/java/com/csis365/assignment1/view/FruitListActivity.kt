package com.csis365.assignment1.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.R
import com.csis365.assignment1.service.FruitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.csis365.assignment1.service.dto.Fruit as Fruit

class FruitListActivity : AppCompatActivity() {
    private lateinit var rvRecyclerview: RecyclerView
    private lateinit var fruitAdapter: FruitAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyc_view)

        supportActionBar!!.title = "Fruits List"

        // handling fruit list
        val fruitService = buildService()
        fruitService.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>,
                                    response: Response<List<Fruit>>) {
                Log.i("asdf","onResponse()")

                rvRecyclerview = findViewById(R.id.rvRecyclerView)
                rvRecyclerview.layoutManager = LinearLayoutManager(this@FruitListActivity)
                rvRecyclerview.setHasFixedSize(true)
                rvRecyclerview.itemAnimator
                rvRecyclerview.apply{
                    val listData: List<Fruit> = response.body()!!
                    fruitAdapter = FruitAdapter(listData!!, this@FruitListActivity)

                    var tempAdapter =  fruitAdapter
                    rvRecyclerview.adapter = tempAdapter
                    tempAdapter.setFruitDetailListener(object : FruitAdapter.FruitDetailListener {
                        override fun onItemClick(position: Int) {
                          }
                    })
                }
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.e("asdf", "onFailure()")
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