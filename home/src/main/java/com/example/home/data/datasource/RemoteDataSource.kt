package com.example.home.data.datasource

import com.example.home.data.datasource.model.CountNotificationResponse
import com.example.home.data.datasource.model.HomeResponse
import com.example.home.data.datasource.model.TitleResponse

interface RemoteDataSource {
    suspend fun getHome(): HomeResponse

    suspend fun getTitleHome(): TitleResponse

    suspend fun getCountNotificationHome(): CountNotificationResponse
}
