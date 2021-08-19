package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)