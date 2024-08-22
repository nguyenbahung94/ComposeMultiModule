package com.example.detail.data.domaincontract.usecase

import com.example.detail.data.datasource.RemoteDataSource
import com.example.detail.data.domaincontract.mapper.mapToItemDetail
import com.example.detail.domain.model.ItemDetail
import com.example.detail.domain.usecase.GetItemDetailUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetItemDetailUseCaseImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : GetItemDetailUseCase {
    override suspend fun getDetail(): Flow<ItemDetail> =
        flow {
            val detailData = dataSource.getDetail().mapToItemDetail()
            emit(detailData)
        }.flowOn(dispatcher)
}
