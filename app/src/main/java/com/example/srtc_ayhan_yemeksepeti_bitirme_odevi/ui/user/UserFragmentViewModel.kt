package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.ApiRepository
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.User
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.UserRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.UserResponse
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserFragmentViewModel @Inject constructor(

    savedStateHandle: SavedStateHandle,
    private val apiRepository: ApiRepository
) : ViewModel() {

    fun getUser(): LiveData<Resource<UserResponse>> = apiRepository.getUser()

}