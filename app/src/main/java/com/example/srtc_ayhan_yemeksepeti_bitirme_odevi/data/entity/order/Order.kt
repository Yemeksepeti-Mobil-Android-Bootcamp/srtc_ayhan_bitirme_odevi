package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order

import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.Meal
import com.google.gson.annotations.SerializedName
import java.util.*

data class Order(
    @SerializedName("_id")
    val id: String,
    @SerializedName("createdDate")
    val createdDate: Date,
    @SerializedName("meal")
    val meal: Meal,
    @SerializedName("restaurant")
    val restaurant: OrderRestaurant,
    @SerializedName("price")
    val price: Double
)