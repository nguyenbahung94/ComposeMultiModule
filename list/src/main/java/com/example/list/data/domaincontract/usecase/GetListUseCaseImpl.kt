package com.example.list.data.domaincontract.usecase

import com.example.list.data.datasource.ListDataSource
import com.example.list.data.domaincontract.mapper.mapToListData
import com.example.list.domain.model.ListData
import com.example.list.domain.usecase.GetListUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetListUseCaseImpl @Inject constructor(
    private val listDataSource: ListDataSource,
    private val dispatcher: CoroutineDispatcher,
) : GetListUseCase {

    override fun getList(): Flow<ListData> =
        flow {
            val initialList = listDataSource.getList().mapToListData()
            emit(initialList)
        }.flowOn(dispatcher)
}
