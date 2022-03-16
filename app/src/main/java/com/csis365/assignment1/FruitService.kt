package com.csis365.assignment1

import com.csis365.assignment1.FruitDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitService {
    //@GET("jokes/random")
    @GET("api/fruit/all")
    fun getJoke(): Call<FruitDetail>

    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<FruitDetail>>

    @GET("api/fruit/{id}")
    fun getFruit(@Path("id") id:Int): Call<FruitDetail>


    /*
    private val key_name = "key_first_name"
    private val key_id = "key_first_name"

    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<Fruit>>

    @GET("api/fruit/{id}")
    fun getFruit(@Path("id") id:Int): Call<Fruit>





    val fruit - Fruit(123, "apple", "red")

    intent
    putExtra  (key, fruit)
    startActivity(intent)

    val serializedFruit = getIntent().getSerializableExtra("key_fruit)
    val fruit_id = getIntent().getIntExtra(key_id, -1)

     */

}
