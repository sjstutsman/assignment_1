package com.csis365.assignment1

import com.csis365.assignment1.Services.Fruits
import retrofit2.Call
import retrofit2.http.GET

interface FruitService {
    @GET("/api/fruit/all")
    fun getFruit(): Call<List<Fruits>>
}