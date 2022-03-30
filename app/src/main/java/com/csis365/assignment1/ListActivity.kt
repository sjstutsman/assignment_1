package com.csis365.assignment1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListActivity : AppCompatActivity() {

    private lateinit var rvFruitList: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_activity)

        rvFruitList = findViewById(R.id.rv_fruitlist)
        rvFruitList.layoutManager = LinearLayoutManager(this)


        val fruitListService = buildFruitList()
        fruitListService.getFruitList().enqueue(object : Callback<List<FruitList>> {
            override fun onResponse(call: Call<List<FruitList>>, response: Response<List<FruitList>>) {

                //Log.i("asdf", "onResponse()")
                rvFruitList.adapter = FruitListAdapter(response.body())
        }

                override fun onFailure(call: Call<List<FruitList>>, t: Throwable) {
            Log.i("asdf", "onFailure()" )
                    rvFruitList.adapter = FruitListAdapter(null)
        }
    })
        }

    private fun buildFruitList(): FruitListService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitListService::class.java)
    }


}
