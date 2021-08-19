package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.common

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("role")
    val role: String
)