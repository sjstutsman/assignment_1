package com.csis365.assignment1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FruitDetail(
    val genus : String?,
    val name: String?,
    val id: Int?,
    val color: String?,
    val order : String?,
    val nutritions: Nutritions?
): Serializable

data class Nutritions(
    val carbohydrates : Double?,
    val protein : Double?,
    val fat : Double?,
    val calories : Double?,
    val sugar : Double?
):Serializable
/*
data class FruitDetail (
    @SerializedName("icon_url")
    val iconUrl : String?,
    val id : String?,
    val url : String,
    @SerializedName("value")
    val jokeString: String?

    /*
    val genus : String
    , val name : String
    , val id : Int
    , val family : String
    , val order : String
    */

    // Inclass
    /*
    data class Fruit(
        id: Int?,
        name: String?,
        color: String?
        ):Serializable

    */
)

 */
