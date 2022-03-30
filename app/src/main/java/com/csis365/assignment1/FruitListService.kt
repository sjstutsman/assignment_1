package com.csis365.assignment1


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitListService {
    @GET("api/fruit/all")
    fun getFruitList(): Call<List<FruitList>>

    @GET("api/fruit/{name}")
    fun getFruitByName(@Path ("name") name : String) : Call<FruitList>


}
