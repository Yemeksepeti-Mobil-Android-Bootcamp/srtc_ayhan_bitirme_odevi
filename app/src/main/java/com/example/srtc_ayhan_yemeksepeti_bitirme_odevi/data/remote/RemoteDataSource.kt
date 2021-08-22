package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.remote

import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrderAddRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.UserRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: APIService
): BaseDataSource() {
    suspend fun login(request: LoginRequest) = getResult { apiService.login(request) }

    suspend fun register(request: RegisterRequest) = getResult { apiService.register(request) }

    suspend fun getRestaurants() = getResult { apiService.getRestaurants() }

    suspend fun getRestaurantsByCategory(category: String) = getResult { apiService.getRestaurantsByCategory(category) }

    suspend fun getRestaurantById(id: String) = getResult { apiService.getRestaurantById(id) }

    suspend fun getMealById(id: String) = getResult { apiService.getMealById(id) }

    suspend fun getUser() = getResult { apiService.getUser() }

    suspend fun updateUser(request : UserRequest) = getResult { apiService.updateUser(request) }

    suspend fun postOrder (request: OrderAddRequest) = getResult { apiService.postOrder(request) }

    suspend fun getOrder() = getResult { apiService.getOrder() }
}
