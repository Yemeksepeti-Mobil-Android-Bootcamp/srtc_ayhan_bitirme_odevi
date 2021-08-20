package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.onboarding.FirstOnBoardingFragment
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.onboarding.SecondOnBoardingFragment
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.onboarding.ThirdOnBoardingFragment

private const val FRAGMENT_COUNT = 3

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = FRAGMENT_COUNT

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstOnBoardingFragment()
            1 -> SecondOnBoardingFragment()
            2 -> ThirdOnBoardingFragment()
            else -> ThirdOnBoardingFragment()
        }
    }
}


