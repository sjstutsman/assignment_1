package com.csis365.assignment1

import FruitAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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


        rvRecyclerview = findViewById(R.id.rvRecyclerView)

        // handling fruit list
        val fruitService = buildService()
        fruitService.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>,
                                    response: Response<List<Fruit>>) {
                Log.i("asdf","onResponse()")

                rvRecyclerview.apply{
                    val listData: List<Fruit> = response.body()!!

                    fruitAdapter = FruitAdapter(listData!!)

                    layoutManager = LinearLayoutManager(this@FruitListActivity)
                    rvRecyclerview.setHasFixedSize(true)
                    var tempAdapter =  fruitAdapter
                    rvRecyclerview.adapter = tempAdapter
                    tempAdapter.setFruitDetailListener(object : FruitAdapter.FruitDetailListener{
                        override fun onItemClick(position: Int) {
                            val intent = Intent(this@FruitListActivity, FruitDetail::class.java)
                            Toast.makeText(this@FruitListActivity, "Fruit no. $position", Toast.LENGTH_SHORT).show()
                            intent.putExtra("Name", listData[position].name)
                            intent.putExtra("Genus:", listData[position].genus)
                            intent.putExtra("Order: ", listData[position].order)
                            intent.putExtra("Id", listData[position].id)
                            intent.putExtra("Family", listData[position].family)
                            intent.putExtra("Nutritions", listData[position].nutritions)
                            intent.putExtra("Key_fruit", Fruit(listData[position].genus,listData[position].name,
                                                                     listData[position].id,listData[position].family,
                                                                     listData[position].order,listData[position].nutritions))
                            startActivity(intent)
                        }
                    })
                    rvRecyclerview.layoutManager
                    rvRecyclerview.itemAnimator

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