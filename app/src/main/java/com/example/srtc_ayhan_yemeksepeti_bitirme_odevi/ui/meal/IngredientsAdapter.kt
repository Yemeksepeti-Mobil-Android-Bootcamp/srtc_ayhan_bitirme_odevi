package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.ItemIngredientCardBinding

class IngredientsAdapter: RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder>() {

    private var ingredientsList = ArrayList<String>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IngredientsAdapter.IngredientsViewHolder {
        val binding = ItemIngredientCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {

        val ingredient = ingredientsList[position]

        holder.binding.ingredientNameTextView.text = ingredient
    }

    override fun getItemCount(): Int = ingredientsList.size

    fun setIngredientsList(ingredient: ArrayList<String>){
        ingredientsList = ingredient
    }


    inner class IngredientsViewHolder(val binding: ItemIngredientCardBinding) :
        RecyclerView.ViewHolder(binding.root)



}