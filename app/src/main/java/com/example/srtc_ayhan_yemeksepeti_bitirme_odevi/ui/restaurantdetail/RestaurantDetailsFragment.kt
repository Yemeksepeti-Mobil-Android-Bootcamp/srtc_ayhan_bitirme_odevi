package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurantdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.Meal
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentRestaurantDetailsBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant.MealsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantDetailsFragment : Fragment() {

    private lateinit var binding: FragmentRestaurantDetailsBinding

    private var mealsAdapter: MealsAdapter = MealsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRestaurantDetailsBinding.inflate(inflater, container, false)
        initViews()
        return binding.root

    }

    private fun initViews() {
        mealsAdapter.setMealsList(setFakeData())
        binding.mealsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mealsRecyclerView.adapter = mealsAdapter
    }

    private fun setFakeData(): ArrayList<Meal> {

        val fakeDataArray = ArrayList<Meal>()
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","19"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","18"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))
        fakeDataArray.add(Meal("String", "with french fries","String","asdasd","Steakhouse Burger","20"))

        return fakeDataArray
    }

}