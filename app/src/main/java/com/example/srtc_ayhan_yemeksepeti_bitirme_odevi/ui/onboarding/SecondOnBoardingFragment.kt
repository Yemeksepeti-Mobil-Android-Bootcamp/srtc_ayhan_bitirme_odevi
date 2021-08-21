package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentSecondOnBoardingBinding

class SecondOnBoardingFragment : Fragment() {

    private var _binding: FragmentSecondOnBoardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondOnBoardingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}