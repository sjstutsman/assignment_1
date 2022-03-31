package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {
    lateinit var sharedPref: SharedPreferences
    lateinit var logout: Button
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        logout = findViewById(R.id.id_logout)
        sharedPref = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        recyclerView = findViewById(R.id.recyclerView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fruityvice.com/api/fruit/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(ApiService::class.java)
        api.getAllFruits().enqueue(object: Callback<List<Fruity>> {
            override fun onResponse(call: Call<List<Fruity>>, response: Response<List<Fruity>>) {
                Log.d("Request --  ","Successful")
                showList(response.body()!!)
            }
            override fun onFailure(call: Call<List<Fruity>>, t: Throwable) {
                Log.d("Request --  ","Failed")
            }
        })



        logout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun showList(fruits: List<Fruity>) {
//        Log.d(fruits[0])
        recyclerView.apply {
            layoutManager = LinearLayoutManager( this@HomeActivity)
            adapter = FruitiesAdapter(fruits)
        }
    }
}