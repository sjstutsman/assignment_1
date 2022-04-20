package com.csis365.assignment1.service

import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface FruitService {

    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<Fruit>>

    @GET("api/fruit/{id}")
    fun getFruit(@Path("id")id: Int): Call<List<Fruit>>

}