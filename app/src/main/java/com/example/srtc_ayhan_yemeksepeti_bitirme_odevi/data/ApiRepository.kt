package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data;

import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.login.LoginRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.order.OrderAddRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.register.RegisterRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.entity.user.UserRequest
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local.LocalDataSource
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.remote.RemoteDataSource
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.performAuthTokenNetworkOperation
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var localDataSource: LocalDataSource,
    private var remoteDataSource: RemoteDataSource
) {
    fun login(request: LoginRequest) = performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.login(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )
    fun saveToken(token:String) = localDataSource.saveToken(token)

    fun register(request: RegisterRequest) = performAuthTokenNetworkOperation(
        call = {
            remoteDataSource.register(request)
        },
        saveToken = {
            localDataSource.saveToken(it)
        }
    )

    fun getRestaurants() =
        performNetworkOperation {
            remoteDataSource.getRestaurants()
        }

    fun getRestaurantById(id: String) =
        performNetworkOperation {
            remoteDataSource.getRestaurantById(id)
        }

    fun getRestaurantsByCategory(category: String) =
        performNetworkOperation {
            remoteDataSource.getRestaurantsByCategory(category)
        }


    fun getMealById(id: String) =
        performNetworkOperation {
            remoteDataSource.getMealById(id)
        }

    fun getUser() = performNetworkOperation {
            remoteDataSource.getUser()
    }

    fun updateUser(request: UserRequest) =  performNetworkOperation {
        remoteDataSource.updateUser(request)
    }

    fun postOrder(request: OrderAddRequest) = performNetworkOperation {
        remoteDataSource.postOrder(request)
    }

    fun getOrder() = performNetworkOperation {
        remoteDataSource.getOrder()
    }
}
