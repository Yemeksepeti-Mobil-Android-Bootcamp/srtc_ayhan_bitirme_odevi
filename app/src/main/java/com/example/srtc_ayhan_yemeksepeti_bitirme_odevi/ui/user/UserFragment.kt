package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentUserBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private lateinit var _binding: FragmentUserBinding
    private val viewModel: UserFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserBinding.inflate(inflater, container, false)
        getUserDetails()
        return _binding.root
    }

    private fun getUserDetails() {
        viewModel.getUser().observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    val user = it.data?.user
                    _binding.userName.text = user?.name
                    Log.v("name bind","$user")
                    _binding.userEmail.text = user?.email
                    _binding.userAddress.text = user?.address
                    _binding.userPhone.text = user?.phone

                }
                Resource.Status.ERROR -> {
                    Log.v("name bind","$it")
                }
            }
        })
    }
}