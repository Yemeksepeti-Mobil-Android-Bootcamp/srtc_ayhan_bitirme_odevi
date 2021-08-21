package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user

import com.google.gson.annotations.SerializedName

data class UserRequest(

    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("place")
    val address: String,
    @SerializedName("profile_image")
    val profileImage: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("orders")
    val orders: List<Any>,
)