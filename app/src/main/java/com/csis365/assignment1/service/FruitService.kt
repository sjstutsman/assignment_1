package com.csis365.assignment1.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET

interface FruitService {

    @GET("fruit/all")
    fun getFruitAll(): Call<List<Fruit>>

    @GET("fruit/apple")
    fun getFruitApple(): Call<List<Fruit>>

    @GET("fruit/apricot")
    fun getFruitApricot(): Call<List<Fruit>>

    @GET("fruit/banana")
    fun getFruitBanana(): Call<List<Fruit>>

    @GET("fruit/blueberry")
    fun getFruitBlueberry(): Call<List<Fruit>>

    @GET("fruit/cherry")
    fun getFruitCherry(): Call<List<Fruit>>

    @GET("fruit/durian")
    fun getFruitDurian(): Call<List<Fruit>>

    @GET("fruit/fig")
    fun getFruitFig(): Call<List<Fruit>>

    @GET("fruit/gooseberry")
    fun getFruitGooseberry(): Call<List<Fruit>>

    @GET("fruit/grapes")
    fun getFruitGrapes(): Call<List<Fruit>>

    @GET("fruit/greenapple")
    fun getFruitGreenApple(): Call<List<Fruit>>

    @GET("fruit/guava")
    fun getFruitGuava(): Call<List<Fruit>>

    @GET("fruit/kiwi")
    fun getFruitKiwi(): Call<List<Fruit>>

    @GET("fruit/lemon")
    fun getFruitLemon(): Call<List<Fruit>>

    @GET("fruit/lime")
    fun getFruitLime(): Call<List<Fruit>>

    @GET("fruit/lingonberry")
    fun getFruitLingonBerry(): Call<List<Fruit>>

    @GET("fruit/lychee")
    fun getFruitLychee(): Call<List<Fruit>>

    @GET("fruit/mango")
    fun getFruitMango(): Call<List<Fruit>>

    @GET("fruit/melon")
    fun getFruitMelon(): Call<List<Fruit>>

    @GET("fruit/orange")
    fun getFruitOrange(): Call<List<Fruit>>

    @GET("fruit/papaya")
    fun getFruitPapaya(): Call<List<Fruit>>

    @GET("fruit/passionfruit")
    fun getFruitPassionFruit(): Call<List<Fruit>>

    @GET("fruit/pear")
    fun getFruitPear(): Call<List<Fruit>>

    @GET("fruit/persimmon")
    fun getFruitPersimmon(): Call<List<Fruit>>

    @GET("fruit/pineapple")
    fun getFruitPineapple(): Call<List<Fruit>>

    @GET("fruit/plum")
    fun getFruitPlum(): Call<List<Fruit>>

    @GET("fruit/raspberry")
    fun getFruitRaspberry(): Call<List<Fruit>>

    @GET("fruit/strawberry")
    fun getFruitStrawberry(): Call<List<Fruit>>

    @GET("fruit/tomato")
    fun getFruitTomato(): Call<List<Fruit>>

    @GET("fruit/umbu")
    fun getFruitUmbu(): Call<List<Fruit>>

    @GET("fruit/watermelon")
    fun getFruitWatermelon(): Call<List<Fruit>>
}