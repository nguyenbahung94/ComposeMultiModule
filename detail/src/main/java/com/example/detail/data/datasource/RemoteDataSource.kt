package com.example.detail.data.datasource

import com.example.detail.data.datasource.model.ItemDetailResponse

interface RemoteDataSource {
    suspend fun getDetail(): ItemDetailResponse
}
