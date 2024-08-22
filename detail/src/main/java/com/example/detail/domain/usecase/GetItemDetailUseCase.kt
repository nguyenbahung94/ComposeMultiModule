package com.example.detail.domain.usecase

import com.example.detail.domain.model.ItemDetail
import kotlinx.coroutines.flow.Flow

interface GetItemDetailUseCase {
    suspend fun getDetail(): Flow<ItemDetail>
}
