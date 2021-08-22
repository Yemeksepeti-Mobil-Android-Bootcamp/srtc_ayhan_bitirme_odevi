package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order

import com.google.gson.annotations.SerializedName

data class OrdersResponse(
    @SerializedName("data")
    val orderList: ArrayList<Order>,
    val success: Boolean
)