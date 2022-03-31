package com.csis365.assignment1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitHome : AppCompatActivity() {
    private val BASE_URL = "https://www.fruityvice.com/api/fruit/"
    private var loggedIn = false
    private lateinit var SharedPreferences : SharedPreferences
    private lateinit var recyclerView: RecyclerView
    private lateinit var welcomeText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruit_home)

        SharedPreferences = getSharedPreferences("SHARED", Context.MODE_PRIVATE)
        loggedIn = SharedPreferences.getBoolean("LOGGEDIN", false)
        welcomeText = findViewById(R.id.welcome)

        var username = SharedPreferences.getString("USERNAME", "")

        val retro =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        recyclerView = findViewById(R.id.recycler_view)


        val api = retro.create(RetroService::class.java)
        api.getAllFruit().enqueue(object:Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {

                Log.d("response","response succesfull")
                recyclerView.layoutManager = LinearLayoutManager(this@FruitHome)

                recyclerView.adapter = FruitListAdapter(response.body()!!)
                welcomeText.setText("Hello, " + username.toString())

                Log.d("username", username.toString())


            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                Log.d("fail", "Error")
            }

        })

    }
}