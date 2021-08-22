package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.order

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.Order
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.FragmentOrderBinding
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFragment : Fragment() {

    private lateinit var binding: FragmentOrderBinding
    private var ordersAdapter: OrdersAdapter = OrdersAdapter()
    private val viewModel: OrderViewModel by viewModels()

    private var adapter = OrdersAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOrderBinding.inflate(inflater, container, false)
        initViews()
        return binding.root
    }

    private fun initViews() {
        binding.ordersRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.ordersRecyclerView.adapter = ordersAdapter
        getOrderDetail()
    }

    private fun getOrderDetail() {
        viewModel.getOrder().observe(viewLifecycleOwner, { response ->
            when (response.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    viewModel.ordersList = response.data?.orderList
                    setOrders(viewModel.ordersList)
                    Log.d(ContentValues.TAG, "getRestaurants: success")
                }
                Resource.Status.ERROR -> {
                    Log.d(ContentValues.TAG, "getRestaurants: ${response.message}")
                }
            }
        })
    }

    private fun setOrders(ordersList: ArrayList<Order>?) {
        if (ordersList != null) {
            adapter.setOrdersList(ordersList)
        }
        binding.ordersRecyclerView.adapter = adapter
    }
}