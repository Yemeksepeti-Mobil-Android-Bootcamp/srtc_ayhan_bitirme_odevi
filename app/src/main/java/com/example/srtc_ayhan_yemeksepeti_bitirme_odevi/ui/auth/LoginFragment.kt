package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.auth

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
   // private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {


        binding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.loginButton.setOnClickListener {
           // login()
        }

    }
//    private fun login(){
//        _binding.loginButton.setOnClickListener {
//            val email = _binding.editTextEmailAdress.text.toString()
//            val password = _binding.editTextPassword.text.toString()
//            viewModel.login(email, password)
//                .observe(viewLifecycleOwner, Observer {
//                    when (it.status) {
//                        Resource.Status.LOADING -> {
//
//                        }
//                        Resource.Status.SUCCESS -> {
//                            val intent = Intent(context, MainActivity::class.java)
//                            startActivity(intent)
//                            requireActivity().finish()
//                        }
//                        Resource.Status.ERROR -> {
//                            val dialog = AlertDialog.Builder(context)
//                                .setTitle("Error")
//                                .setMessage("${it.message}")
//                                .setPositiveButton("ok") { dialog, button ->
//                                    dialog.dismiss()
//                                }
//                            dialog.show()
//                        }
//                    }
//                })
//
//        }
//    }
}