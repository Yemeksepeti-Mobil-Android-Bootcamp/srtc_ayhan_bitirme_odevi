package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.Meal
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.MealResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrderAddRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrderAddResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealDetailsViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {
    var meal: Meal? = null

    fun getMealDetails(id: String): LiveData<Resource<MealResponse>> {
        return apiRepository.getMealById(id)
    }

    fun postOrder(request: OrderAddRequest): LiveData<Resource<OrderAddResponse>>{
        return apiRepository.postOrder(request)
    }

}