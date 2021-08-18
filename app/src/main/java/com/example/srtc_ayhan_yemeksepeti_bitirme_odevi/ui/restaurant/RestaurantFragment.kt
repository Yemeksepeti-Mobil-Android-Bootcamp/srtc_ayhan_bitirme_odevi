package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentRestaurantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantFragment : Fragment() {

    private lateinit var binding: FragmentRestaurantBinding

    private var restaurantsAdapter: RestaurantsAdapter = RestaurantsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        initViews()
        return binding.root

    }

    private fun initViews() {
        restaurantsAdapter.setRestaurantsList(setFakeData())
        binding.restaurantRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.restaurantRecyclerView.adapter = restaurantsAdapter

    }

    private fun setFakeData(): ArrayList<Restaurant> {

        val fakeDataArray = ArrayList<Restaurant>()
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "McDonalds"))
        fakeDataArray.add(Restaurant("String", "Arbys"))
        fakeDataArray.add(Restaurant("String", "Ohannes Burger"))
        fakeDataArray.add(Restaurant("String", "Maxwell Burger"))
        fakeDataArray.add(Restaurant("String", "Burger Diyarı"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))
        fakeDataArray.add(Restaurant("String", "Burger King"))

        return fakeDataArray
    }

}