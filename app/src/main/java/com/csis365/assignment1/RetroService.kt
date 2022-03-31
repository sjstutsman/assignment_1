package com.csis365.assignment1

import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("all")

    fun getAllFruit():Call<List<Fruit>>

}