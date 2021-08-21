package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.R
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.Category
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private var categoriesAdapter: CategoriesAdapter = CategoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initViews()
        return binding.root

    }

    private fun initViews() {
        categoriesAdapter.setCategoriesList(setFakeData())
        binding.categoryRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.categoryRecyclerView.adapter = categoriesAdapter
    }

    private fun setFakeData(): ArrayList<Category> {

        val fakeDataArray = ArrayList<Category>()
        fakeDataArray.add(Category(R.drawable.hamburger, "All Restaurants"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Burger"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Cig Kofte"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Pizza"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Fish and Seafood"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Turkish Doner"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Pasta & Salad"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Manti"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Baked Potato"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Kokorec"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Rice"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Chicken"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Waffle"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Eastern"))

        return fakeDataArray
    }

}