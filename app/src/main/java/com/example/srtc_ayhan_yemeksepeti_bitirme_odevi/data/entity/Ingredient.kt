package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("ingredient")
    var ingredient: String,
    @SerializedName("includes")
    var includes: Boolean
)
