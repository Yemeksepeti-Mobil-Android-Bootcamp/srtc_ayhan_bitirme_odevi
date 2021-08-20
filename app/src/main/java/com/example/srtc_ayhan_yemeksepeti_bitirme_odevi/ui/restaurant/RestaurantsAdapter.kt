package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurant

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.restaurant.Restaurant
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.RestaurantCardBinding

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    private var restaurantList = ArrayList<Restaurant>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantsAdapter.RestaurantsViewHolder {
        val binding = RestaurantCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        Log.d(TAG, "onBindViewHolder: $restaurant")

        //glide
        Glide.with(holder.binding.restaurantCardImg.context)
            .load(restaurant.image)
            .into(holder.binding.restaurantCardImg)
        holder.binding.restaurantCardText.text = restaurant.name

        holder.binding.restaurantCardView.setOnClickListener {
            val action = RestaurantFragmentDirections.actionRestaurantFragmentToRestaurantDetailsFragment(restaurant.id)
            it.findNavController()
                .navigate(action)
        }
    }

    override fun getItemCount(): Int = restaurantList.size


    fun setRestaurantList(restaurantList: ArrayList<Restaurant>?) {
        restaurantList?.let {
            this.restaurantList = restaurantList
            notifyDataSetChanged()
        }
    }

    inner class RestaurantsViewHolder(val binding: RestaurantCardBinding) :
        RecyclerView.ViewHolder(binding.root)

}