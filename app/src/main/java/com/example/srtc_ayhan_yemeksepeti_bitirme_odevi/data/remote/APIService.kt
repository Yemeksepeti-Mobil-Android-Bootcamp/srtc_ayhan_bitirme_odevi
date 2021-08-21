package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.remote

import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.MealResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.RestaurantListResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.RestaurantResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @GET("a/restaurant")
    suspend fun getRestaurants(): Response<RestaurantListResponse>

    @GET("a/restaurant/{id}")
    suspend fun getRestaurantById(@Path("id") id: String): Response<RestaurantResponse>

    @GET("a/meal/{id}")
    suspend fun getMealById(@Path("id") id: String): Response<MealResponse>
}