package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    var ApiRepository: ApiRepository
) : ViewModel(){
    fun login(email: String, password: String): LiveData<Resource<LoginResponse>> {
        val request = LoginRequest(email, password)
        return ApiRepository.login(request)
    }
}