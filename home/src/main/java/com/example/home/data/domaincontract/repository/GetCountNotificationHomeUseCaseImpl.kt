package com.example.home.data.domaincontract.repository

import com.example.home.data.datasource.RemoteDataSource
import com.example.home.domain.usecase.GetCountNotificationHomeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlin.random.Random

internal class GetCountNotificationHomeUseCaseImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher
) : GetCountNotificationHomeUseCase {
    override fun getCountNotificationHome(): Flow<Int> =
        flow {
            dataSource.getCountNotificationHome() // this is a fake call
            val count = Random.nextInt(100)
            emit(count)
        }.flowOn(dispatcher)
}
