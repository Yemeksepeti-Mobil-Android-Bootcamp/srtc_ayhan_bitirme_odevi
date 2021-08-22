package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.meal

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrderAddRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentMealDetailsBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealDetailsFragment : Fragment() {

    private val args: MealDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentMealDetailsBinding
    private val viewModel: MealDetailsViewModel by viewModels()

    private var ingredientsAdapter: IngredientsAdapter = IngredientsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMealDetailsBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(context)
        getMealDetail()
        initListeners()
    }

    private fun initListeners() {
        binding.orderButton.setOnClickListener {
            val orderAddRequest = OrderAddRequest(args.restaurantId, args.mealId)
            viewModel.postOrder(
                orderAddRequest
            ).observe(viewLifecycleOwner, {
                when (it.status) {
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                       Log.v("meal","success")
                    }
                    Resource.Status.ERROR -> {
                        Log.v("meal","{$it}")
                    }
                }
            })
        }
    }

    private fun getMealDetail() {
        viewModel.getMealDetails(args.mealId).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    val meal = it.data!!.data
                    setIngredients(meal.mealIngredients)
                    binding.mealNameTextView.text = meal.mealName
                    binding.mealDescTextView.text = meal.mealDesc
                    binding.mealPriceTextView.text = meal.mealPrice + ".00 TL"

                    Glide.with(binding.mealDetailImageView.context)
                        .load(meal.mealImage).into(binding.mealDetailImageView)

                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    private fun setIngredients(ingredientList: ArrayList<String>) {
        ingredientsAdapter.setIngredientsList(ingredientList)
        binding.ingredientsRecyclerView.adapter = ingredientsAdapter
    }

}