package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.MainActivity
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local.SharedPrefManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}