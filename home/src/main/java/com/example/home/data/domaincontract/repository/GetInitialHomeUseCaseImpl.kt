package com.example.home.data.domaincontract.repository

import com.example.home.data.datasource.RemoteDataSource
import com.example.home.data.domaincontract.mapper.mapToHomeSections
import com.example.home.domain.model.HomeSection
import com.example.home.domain.usecase.GetInitialHomeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class GetInitialHomeUseCaseImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : GetInitialHomeUseCase {
    override fun getInitialHome(): Flow<HomeSection> =
        flow {
            val initialData = dataSource.getHome().mapToHomeSections()
            emit(initialData)
        }.flowOn(dispatcher)
}
