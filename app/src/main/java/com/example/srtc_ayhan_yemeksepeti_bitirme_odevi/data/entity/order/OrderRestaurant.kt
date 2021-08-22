package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order

import com.google.gson.annotations.SerializedName

data class OrderRestaurant(
    @SerializedName("name")
    val name: String)