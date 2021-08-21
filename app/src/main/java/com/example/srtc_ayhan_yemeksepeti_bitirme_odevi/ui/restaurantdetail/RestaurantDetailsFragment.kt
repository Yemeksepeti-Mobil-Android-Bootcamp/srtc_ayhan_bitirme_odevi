package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.restaurantdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.meal.Meal
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentRestaurantDetailsBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantDetailsFragment : Fragment() , IMealOnClick {

    private val args: RestaurantDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentRestaurantDetailsBinding
    private val viewModel: RestaurantDetailsViewModel by viewModels()

    private var restaurantName = ""

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
        binding.mealsRecyclerView.layoutManager = LinearLayoutManager(context)
        getRestaurantDetail()

    }

    private fun getRestaurantDetail() {
        viewModel.getRestaurantDetail(args.restaurantId).observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    val restaurant = it.data!!.data
                    setMeals(restaurant.meals)
                    restaurantName = restaurant.name
                    binding.restaurantNameTextView.text = restaurant.name
                    binding.restaurantAddressTextView.text = restaurant.address
                    binding.deliveryInfoTextView.text = restaurant.deliveryInfo
                    binding.minimumFeeTextView.text = restaurant.minimumDeliveryFee + ".00 TL"

                    Glide.with(binding.restaurantImageView.context)
                        .load(restaurant.image).into(binding.restaurantImageView)
                }
                Resource.Status.ERROR -> {

                }
            }
        })
    }

    private fun setMeals(mealList: ArrayList<Meal>) {

        mealsAdapter.setListener(this)
        mealsAdapter.setMealsList(mealList)
        binding.mealsRecyclerView.adapter = mealsAdapter

    }

    override fun onClick(mealId: String) {

        val action = RestaurantDetailsFragmentDirections.actionRestaurantDetailsFragmentToMealDetailsFragment2(mealId, args.restaurantId, restaurantName)
        findNavController().navigate(action)
    }


//    private fun setFakeData(): ArrayList<Meal> {
//
//        val fakeDataArray = ArrayList<Meal>()
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","19"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","18"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//        fakeDataArray.add(Meal("String", "with french fries","String",ArrayList<String>(),"Steakhouse Burger","20"))
//
//        return fakeDataArray
//    }

}

