package com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.di

import android.content.Context
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local.LocalDataSource
import com.example.srtc_ayhan_yemeksepeti_bitirme_odevi.data.local.SharedPrefManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(
    SingletonComponent::class
)
class DatabaseModule {

    @Provides
    fun sharedPrefManager(@ApplicationContext context: Context): SharedPrefManager {
        return SharedPrefManager(context)
    }

    @Provides
    fun localDataSource(sharedPrefManager: SharedPrefManager): LocalDataSource {
        return LocalDataSource(sharedPrefManager)
    }
}