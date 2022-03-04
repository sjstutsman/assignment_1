package com.csis365.assignment1.service.dto

import com.google.gson.annotations.SerializedName

data class FruitNutrition (
    @SerializedName("carbohydrates")
    val carbs: Double?,
    val protein: Double?,
    val fat: Double?,
    val calories: Double?,
    val sugar: Double?
){
}