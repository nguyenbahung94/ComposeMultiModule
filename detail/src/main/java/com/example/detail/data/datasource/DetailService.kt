package com.example.detail.data.datasource

import com.example.detail.data.datasource.model.ItemDetailResponse
import retrofit2.Response
import retrofit2.http.GET

interface DetailService {
    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/detail-page")
    suspend fun getDetail(): Response<ItemDetailResponse>
}
