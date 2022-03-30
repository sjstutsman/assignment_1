package com.csis365.assignment1

import android.util.JsonReader
import com.google.gson.annotations.SerializedName

data class Nutrish(
    val carbohydrates: Double?,
    val protein: Double?,
    val fat: Double?,
    val calories: Double?,
    val sugar: Double?
)
{

}
