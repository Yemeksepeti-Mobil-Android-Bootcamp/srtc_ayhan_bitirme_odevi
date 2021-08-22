package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.ui.order

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.Order
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.databinding.OrderItemCardBinding
import java.text.SimpleDateFormat

class OrdersAdapter : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {

    private var ordersList = ArrayList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersViewHolder {
        val binding = OrderItemCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(binding)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        val order = ordersList[position]

        Glide.with(holder.binding.orderCardImg.context)
            .load(order.meal.mealImage)
            .into(holder.binding.orderCardImg)

        holder.binding.orderCardName.text = order.meal.mealName
        holder.binding.orderCardRestaurant.text = order.restaurant.name
        holder.binding.orderCardDate.text = SimpleDateFormat("dd/MM/yyyy").format(order.createdDate).toString()
        holder.binding.orderPrice.text = order.meal.mealPrice.toString() + "TL"

    }

    override fun getItemCount(): Int = ordersList.size

    fun setOrdersList(ordersList: ArrayList<Order>) {
        ordersList?.let {
            this.ordersList = ordersList
            notifyDataSetChanged()
        }

    }


    inner class OrdersViewHolder(val binding: OrderItemCardBinding) :
        RecyclerView.ViewHolder(binding.root)


}