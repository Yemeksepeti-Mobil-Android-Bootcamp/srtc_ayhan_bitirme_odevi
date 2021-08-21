package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentRestaurantBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    private lateinit var _binding: FragmentRestaurantBinding
    private val viewModel: RestaurantViewModel by viewModels()

    private var adapter = RestaurantsAdapter()

    private var restaurantsAdapter: RestaurantsAdapter = RestaurantsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        initViews()
        return _binding.root

    }

    private fun initViews() {
        _binding.restaurantRecyclerView.layoutManager = GridLayoutManager(context, 2)
        _binding.restaurantRecyclerView.adapter = restaurantsAdapter
        getRestaurants()
    }

    private fun getRestaurants() {
        viewModel.getRestaurants().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    viewModel.restaurantList = response.data?.restaurantList
                    setRestaurants(viewModel.restaurantList)
                    Log.d(TAG, "getRestaurants: success")
                }
                Resource.Status.ERROR -> {
                    Log.d(TAG, "getRestaurants: ${response.message}")
                }
            }
        })
    }

    private fun setRestaurants(restaurantList: ArrayList<Restaurant>?) {
        adapter.setRestaurantList(restaurantList)
        _binding.restaurantRecyclerView.adapter = adapter
    }

}