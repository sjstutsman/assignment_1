package com.csis365.assignment1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Path

class ListFruit : AppCompatActivity() {

    private lateinit var userNameFruit: TextView
    private val key_id = "key_first_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_fruit)


        // Test output
        val value1 = intent.getStringExtra("value")

        if (value1 != null) {
            Log.d("Login", value1)
            userNameFruit = findViewById(R.id.userNameFruit)
            userNameFruit.setText("User name is: " + value1)
        }


        // get info

        val jokeService = buildService()

        // getAllFruits implementation
        // val jokeService = buildService()


        jokeService.getAllFruit().enqueue(object : Callback<List<FruitDetail>> {
            override fun onResponse(call: Call<List<FruitDetail>>, response: Response<List<FruitDetail>>) {
                Log.i("allFruit", "onResponse()")
            }

            override fun onFailure(call: Call<List<FruitDetail>>, t: Throwable) {
                Log.e("allFruit", "onFailure()")
            }
        })

        /*
        val fruitList = POST()
        val intentListFruit = Intent(this, ListFruit::class.java)
        intentListFruit.putExtra("value", userName.text.toString())
        startActivity(intentListFruit)
        */


        // getAllFruits implementation
        // val jokeService = buildService()
        //var id = getI
        jokeService.getFruit(id = 1).enqueue(object : Callback<FruitDetail> {
            override fun onResponse(call: Call<FruitDetail>, response: Response<FruitDetail>) {
                Log.i("oneFruit", "onResponse()")
            }

            override fun onFailure(call: Call<FruitDetail>, t: Throwable) {
                Log.e("oneFruit", "onFailure()")
            }

        })


        // getJoke implementation
        //val jokeService = buildService()
        jokeService.getJoke().enqueue(object : Callback<FruitDetail> {
            override fun onResponse(call: Call<FruitDetail>, response: Response<FruitDetail>) {
                Log.i("asdf", "onResponse()")
            }

            override fun onFailure(call: Call<FruitDetail>, t: Throwable) {
                Log.e("asdf", "onFailure()")
            }

        })


    }



    // generator class
    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            //.baseUrl("https://api.chucknorris.io/")
            .baseUrl("https://fruityvice.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //val service: JokeService = retrofit.create(JokeService::class.java)
        return retrofit.create(FruitService::class.java)
    }


    /*
    private val key_name = "key_first_name"
    private val key_id = "key_first_name"

    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<Fruit>>

    @GET("api/fruit/{id}")
    fun getFruit(@Path("id") id:Int): Call<Fruit>





    val fruit - Fruit(123, "apple", "red")

    intent(... , ....)
    putExtra  (key, fruit)
    startActivity(intent)

    val serializedFruit = getIntent().getSerializableExtra("key_fruit)
    val fruit_id = getIntent().getIntExtra(key_id, -1)

     */
}