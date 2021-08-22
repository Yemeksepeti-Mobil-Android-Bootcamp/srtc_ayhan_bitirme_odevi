package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.UserRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentUserUpdateBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserUpdateFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentUserUpdateBinding
    private val viewModel: UserUpdateFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserUpdateBinding.inflate(inflater, container, false)
        initListeners()
        getUserDetails()

        return binding.root
    }

    private fun initListeners() {
        binding.updateButton.setOnClickListener{
            updateUserDetails()
        }
    }

    private fun getUserDetails() {
        viewModel.getUser().observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    val user = it.data?.user
                    binding.userNameEditText.setText(user?.name)
                    binding.userEmailEditText.setText(user?.email)
                    binding.userAddressEditText.setText(user?.address)
                    binding.userPhoneEditText.setText(user?.phone)

                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    private fun updateUserDetails() {

        val userName = binding.userNameEditText.text.toString()
        val userEmail = binding.userEmailEditText.text.toString()
        val userAddress = binding.userAddressEditText.text.toString()
        val userPhone = binding.userPhoneEditText.text.toString()

        val user = UserRequest(userName, userEmail, userAddress, userPhone)

        viewModel.updateUser(user).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    dismiss()
                }
                Resource.Status.ERROR -> {

                }
            }
        })

    }
}