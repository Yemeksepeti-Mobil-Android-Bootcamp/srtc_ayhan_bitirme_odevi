package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("_id")
    val mealId: String,
    @SerializedName("description")
    val mealDesc: String,
    @SerializedName("imageUrl")
    val mealImage: String,
    @SerializedName("ingredients")
    val mealIngredients: ArrayList<String>,
    @SerializedName("name")
    val mealName: String,
    @SerializedName("price")
    val mealPrice: String,
)
