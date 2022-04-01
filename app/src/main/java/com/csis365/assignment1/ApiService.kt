package com.csis365.assignment1

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("all")
    fun getAllFruits(): Call<List<Fruity>>

}