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
class UserUpdateFragmentViewModel @Inject constructor(
    var savedStateHandle: SavedStateHandle,
    private var apiRepository: ApiRepository
) : ViewModel() {

    fun getUser(): LiveData<Resource<UserResponse>> = apiRepository.getUser()

    fun updateUser(request: UserRequest): LiveData<Resource<User>> = apiRepository.updateUser(request)
}