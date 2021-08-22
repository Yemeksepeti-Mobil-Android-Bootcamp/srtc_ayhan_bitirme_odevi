package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.order

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.Order
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrdersResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    var ordersList: ArrayList<Order>? = null

    fun getOrder(): LiveData<Resource<OrdersResponse>> =
        apiRepository.getOrder()
}