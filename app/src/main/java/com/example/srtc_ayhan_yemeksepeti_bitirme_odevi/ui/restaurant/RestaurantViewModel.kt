package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.RestaurantListResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    var restaurantList: ArrayList<Restaurant>? = null

    fun getRestaurants(): LiveData<Resource<RestaurantListResponse>> =
        apiRepository.getRestaurants()

    fun getRestaurantsByCategory(category: String): LiveData<Resource<RestaurantListResponse>> =
        apiRepository.getRestaurantsByCategory(category)
}