package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.Category
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.ItemCardBinding

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    private var categoriesList = ArrayList<Category>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding = ItemCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categoriesList[position]

        holder.binding.itemCardImg.setImageResource(category.categoryImage)
        holder.binding.itemCardText.text = category.categoryName

// navigate home fragment to restaurant fragment

        holder.binding.itemCardView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToRestaurantFragment(category.categoryName)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = categoriesList.size

    fun setCategoriesList(categories: ArrayList<Category>) {
        categoriesList = categories
    }

    inner class CategoriesViewHolder(val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)
}