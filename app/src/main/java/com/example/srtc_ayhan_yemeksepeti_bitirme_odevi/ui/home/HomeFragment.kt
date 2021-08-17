package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
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
        fakeDataArray.add(Category("String", "Pide"))
        fakeDataArray.add(Category("String", "Hamburger"))
        fakeDataArray.add(Category("String", "Pizza"))
        fakeDataArray.add(Category("String", "Suşi"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))
        fakeDataArray.add(Category("String", "Balık"))

        return fakeDataArray
    }

}