package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}