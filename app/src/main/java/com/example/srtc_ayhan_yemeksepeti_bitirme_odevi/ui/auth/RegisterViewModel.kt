package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val apiRepository: ApiRepository
) : ViewModel() {

    fun register(
        name: String,
        email: String,
        password: String
    ): LiveData<Resource<RegisterResponse>> {
        val request = RegisterRequest(name, email, password)
        return apiRepository.register(request)
    }

    fun saveToken(token: String) {
        apiRepository.saveToken(token)
    }
}