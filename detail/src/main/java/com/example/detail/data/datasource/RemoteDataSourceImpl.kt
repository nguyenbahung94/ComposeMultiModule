package com.example.detail.data.datasource

import com.example.detail.data.datasource.model.ItemDetailResponse
import com.example.network.extensions.handleCall
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val service: DetailService,
) : RemoteDataSource {
    override suspend fun getDetail(): ItemDetailResponse {
        return handleCall {
            service.getDetail()
        }
    }
}
