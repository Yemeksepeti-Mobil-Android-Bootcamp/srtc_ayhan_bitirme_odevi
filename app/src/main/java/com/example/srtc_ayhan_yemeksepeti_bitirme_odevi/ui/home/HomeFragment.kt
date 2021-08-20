package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        fakeDataArray.add(Category(R.drawable.hamburger, "Burger"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Çiğ Köfte"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Pizza"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Balık ve Deniz Ürünleri"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Döner"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Makarna & Salata"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Mantu"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Kumpir"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Kokoreç"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Pilav"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Tavuk"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Waffle"))
        fakeDataArray.add(Category(R.drawable.hamburger, "Uzak Doğu"))

        return fakeDataArray
    }

}