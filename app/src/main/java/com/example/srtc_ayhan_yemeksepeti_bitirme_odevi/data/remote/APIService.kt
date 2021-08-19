package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.remote

import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}