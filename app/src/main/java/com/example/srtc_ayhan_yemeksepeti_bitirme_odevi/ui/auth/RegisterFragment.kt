package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentRegisterBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.MainActivity
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var _binding: FragmentRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.button.setOnClickListener {
            val name = _binding.editTextName.text.toString()
            val email = _binding.editTextEmail.text.toString()
            val password = _binding.editTextPassword.text.toString()
            viewModel.register(email, name, password)
                .observe(viewLifecycleOwner, {
                    when (it.status) {
                        Resource.Status.LOADING -> {
                        }
                        Resource.Status.SUCCESS -> {
                            viewModel.saveToken(it.data!!.token)
                            val intent = Intent(context, MainActivity::class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        }
                        Resource.Status.ERROR -> {
                        }
                    }
                })
        }
    }
}