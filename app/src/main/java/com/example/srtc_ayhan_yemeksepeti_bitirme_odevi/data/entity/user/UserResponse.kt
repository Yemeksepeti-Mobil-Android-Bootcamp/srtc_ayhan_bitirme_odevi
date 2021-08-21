package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val user: User,
    @SerializedName("success")
    val success: Boolean
)