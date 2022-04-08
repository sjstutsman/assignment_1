package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
    private lateinit var rvFruitList: RecyclerView
    private var keyFruit = "key_fruit"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_list)

        rvFruitList = findViewById(R.id.rv_fruit_list)
        rvFruitList.layoutManager = LinearLayoutManager(this)

        val fruitService = buildService()
        fruitService.getFruitAll().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.i("asdf", "onResponse() in list")

                val fruitlistcall = response.body()

                Log.i("asdf", "fruitlistcall was set as response.body()")

                fruitlistcall?.let{
                    rvFruitList.adapter = FruitListAdapter(it)
                    Log.i("asdf", "fruitlist adapter should be set")
                }

            }
            override fun onFailure(call: Call<List<Fruit>>, t: Throwable){
                Log.i("asdf", "FruitAPI call failed in list")
            }
        })



    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fruityvice.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)
    }

    fun GotoFruit(fruitClicked: String?){
        val intent = Intent(this, FruitDetailActivity::class.java).apply{
            putExtra("fruitWanted", fruitClicked)
        }
        startActivity(intent)
    }
}