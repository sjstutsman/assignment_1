package com.csis365.assignment1.Services

import java.io.Serializable

data class Fruits(
        val name: String?,
        val genus: String?,
        val id: Int?,
        val family: String?,
        val order: String?,
        val nutritions: Nutrition,
):Serializable

data class Nutrition(
        val carbohydrates: Double?,
        val protein: Double?,
        val fat: Double?,
        val calories: Double?,
        val sugar: Double?,
):Serializable
