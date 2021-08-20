package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local.SharedPrefManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentOnBoardingBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    private var _binding: FragmentOnBoardingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        val view = binding.root
        initViewPager()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        binding.onboardingNext.setOnClickListener {
/*            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)*/

            binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0) {
                        binding.onboardingNext.setOnClickListener {
                            binding.viewPager.currentItem = binding.viewPager.currentItem + 1
                        }
                    } else if (position == 2) {
                        binding.onboardingNext.text = "Finish"
                        binding.onboardingNext.setOnClickListener {
                            SharedPrefManager(requireContext()).setOnboardingSeen()
                            findNavController().navigate(R.id.action_onBoardingFragment_to_loginFragment)

                        }
                    } else {
                        binding.onboardingNext.text = "Next"
                        binding.onboardingNext.setOnClickListener {
                            binding.viewPager.currentItem =
                                binding.viewPager.currentItem + 1
                        }
                        }
                    }

            })
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        binding.wormDotsIndicator.setViewPager2(binding.viewPager)
        //binding.viewPager.setPageTransformer(GateTransformation())
    }

}