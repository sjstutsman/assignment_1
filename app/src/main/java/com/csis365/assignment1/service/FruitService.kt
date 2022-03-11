package com.csis365.assignment1.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitService {

    @GET("fruit/all")
    fun getFruitAll(): Call<List<Fruit>>

    @GET("fruit/{id}")
    fun getFruit(@Path("id") id:Int): Call<Fruit>

}