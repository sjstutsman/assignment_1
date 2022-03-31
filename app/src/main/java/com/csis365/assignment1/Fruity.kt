package com.csis365.assignment1

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fruity(
    val id: String,
    val name: String,
    val genus: String,
    val family: String,
    val order: String,
    val nutritions: Nutrition
):Parcelable

@Parcelize
data class Nutrition(
    val carbohydrates: Float,
    val protein: Float,
    val calories: Int,
    val sugar: Float
):Parcelable