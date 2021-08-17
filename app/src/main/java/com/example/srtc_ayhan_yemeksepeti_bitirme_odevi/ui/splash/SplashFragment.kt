package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentSplashBinding.inflate(inflater, container, false)
        initViews()
        return binding.root

    }

    private fun initViews() {

        binding.lottieAnimation.addAnimatorListener(object: Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {
                Log.v("Animation","Started")
            }

            override fun onAnimationEnd(animation: Animator?) {
                findNavController().navigate(R.id.action_splashFragment_to_onBoardingFragment)


            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.v("Animation","Canceled")
            }

            override fun onAnimationRepeat(animation: Animator?) {
                Log.v("Animation","Repeated")
            }
        })
    }

}