package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user

import com.google.gson.annotations.SerializedName

data class UserRequest(

    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("place")
    val address: String,
    @SerializedName("phone")
    val phone: String,

)