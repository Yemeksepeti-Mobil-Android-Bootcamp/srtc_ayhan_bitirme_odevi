package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.auth

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentLoginBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.MainActivity
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var _binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        _binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        _binding.loginButton.setOnClickListener {
            val email = _binding.editTextEmailAdress.text.toString()
            val password = _binding.editTextPassword.text.toString()
            viewModel.login(email, password)
                .observe(viewLifecycleOwner, Observer {
                    when (it.status) {
                        Resource.Status.LOADING -> {

                        }
                        Resource.Status.SUCCESS -> {
                            val intent = Intent(context, MainActivity::class.java)
                            startActivity(intent)
                            requireActivity().finish()
                        }
                        Resource.Status.ERROR -> {
                            val dialog = AlertDialog.Builder(context)
                                .setTitle("Error")
                                .setMessage("${it.message}")
                                .setPositiveButton("ok") { dialog, button ->
                                    dialog.dismiss()
                                }
                            dialog.show()
                        }
                    }
                })
        }
    }
}