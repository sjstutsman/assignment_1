package com.csis365.assignment1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitRetrofit {
    var juicyfit: Retrofit = retrofit2.Retrofit.Builder()
        .baseUrl("https://www.fruityvice.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    var service: FruityViceService = juicyfit.create(FruityViceService::class.java)

}