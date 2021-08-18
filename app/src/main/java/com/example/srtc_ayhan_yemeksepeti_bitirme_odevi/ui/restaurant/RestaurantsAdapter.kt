package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.RestaurantCardBinding

class RestaurantsAdapter: RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    private var restaurantsList = ArrayList<Restaurant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsAdapter.RestaurantsViewHolder {
        val binding = RestaurantCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurant = restaurantsList[position]

        holder.binding.restaurantCardImg.setImageResource(R.drawable.hamburger)
        holder.binding.restaurantCardText.text = restaurant.restaurantName
        holder.binding.restaurantCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_restaurantFragment_to_restaurantDetailsFragment)
        }
    }
    override fun getItemCount(): Int = restaurantsList.size

    fun setRestaurantsList(restaurant: ArrayList<Restaurant>){
        restaurantsList = restaurant
    }

    inner class RestaurantsViewHolder(val binding: RestaurantCardBinding): RecyclerView.ViewHolder(binding.root)

}