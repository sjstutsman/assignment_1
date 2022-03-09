package com.csis365.assignment1

import com.google.gson.annotations.SerializedName

data class Fruit (
    @SerializedName("name")
    val carbohydrates:String?,
    val genus:String?,
    val protein:String?,
    val name:String?,
    val fat:String?,
    val calories: String?,
    val id:String?,
    val family:String?,
    val sugar:String?,
    val order:String?
) {}