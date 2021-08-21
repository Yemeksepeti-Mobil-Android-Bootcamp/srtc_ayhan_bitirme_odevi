package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurantdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.Meal
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.MealItemCardBinding

class MealsAdapter : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    private var mealsList = ArrayList<Meal>()

    private var listener: IMealOnClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val binding = MealItemCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        val meal = mealsList[position]

        Glide.with(holder.binding.mealCardImg.context)
            .load(meal.mealImage)
            .into(holder.binding.mealCardImg)
        holder.binding.mealCardImg.setImageResource(R.drawable.menu_photo)
        holder.binding.mealCardName.text = meal.mealName
        holder.binding.mealCardDesc.text = meal.mealDesc
        holder.binding.mealPrice.text = meal.mealPrice

        holder.binding.mealItemCardView.setOnClickListener {

            listener?.onClick(meal.mealId)
        }

    }

    override fun getItemCount(): Int = mealsList.size

    fun setMealsList(meal: ArrayList<Meal>) {
        mealsList = meal
    }

    fun setListener(listener: IMealOnClick) {
        this.listener = listener
    }

    fun removeListener() {
        this.listener = null
    }

    inner class MealsViewHolder(val binding: MealItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)

}