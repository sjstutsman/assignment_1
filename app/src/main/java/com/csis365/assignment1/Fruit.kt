package com.csis365.assignment1

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Fruit (
    //val carbohydrates:String?,
    val genus:String?,
    //val protein:String?,
    val name:String?,
    //val calories: String?,
    val id:Int?,
    val family:String?,
    //val sugar:String?,
    val nutritions:JsonElement?,
    val order:String?
) {}

data class Nutritions (
    val carbohydrates:Int?,
    val sugar:Int?,
    val protein:Int?,
    val fat:Int?,
    val calories: Int?
        ){}