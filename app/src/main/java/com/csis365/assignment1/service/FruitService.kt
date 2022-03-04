package com.csis365.assignment1.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET

interface FruitService {

    @GET("fruit/all")
    fun getAllFruit(): Call<List<Fruit>>
}