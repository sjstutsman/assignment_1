package com.csis365.assignment1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface FruityViceService {
    @GET("api/fruit/all")
    fun listRepos(): Call<Fruit>
}