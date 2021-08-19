package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local

import javax.inject.Inject

class LocalDataSource @Inject constructor(
    val sharedPrefManager: SharedPrefManager) {

    fun saveToken(token: String) {
        sharedPrefManager.saveToken(token)
    }

    fun getToken(): String? {
        return sharedPrefManager.getToken()
    }
}