package com.example.home.data.datasource

import com.example.home.data.datasource.model.CountNotificationResponse
import com.example.home.data.datasource.model.HomeResponse
import com.example.home.data.datasource.model.TitleResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeService {

    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/home")
    suspend fun getHome(): Response<HomeResponse>

    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/title")
    suspend fun getTitleHome(): Response<TitleResponse>

    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/notification")
    suspend fun getCountNotificationHome(): Response<CountNotificationResponse>
}