package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {
    companion object {
        const val TOKEN = "com.bootcampers.englishwordapp.TOKEN"
    }

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPreferences.edit().putString(TOKEN, token).apply()
    }

    fun getToken(): String? {
        return sharedPreferences.getString(TOKEN, "")
    }
    fun setOnboardingSeen(){
        sharedPreferences.edit().putBoolean("ONBOARDING",true).apply()
    }

    fun getOnboardingSeen() : Boolean{
        return sharedPreferences.getBoolean("ONBOARDING",false)
    }
}