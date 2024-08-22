package com.example.home.data.domaincontract.usecase

import com.example.core.utils.Constants.VALUE_100
import com.example.home.data.datasource.RemoteDataSource
import com.example.home.domain.usecase.GetTitleHomeUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.Random
import javax.inject.Inject

internal class GetTitleHomeUseCaseImpl @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val dispatcher: CoroutineDispatcher,
) : GetTitleHomeUseCase {
    override fun getTitleHome(): Flow<String> =
        flow {
            dataSource.getTitleHome() // This is a fake call
            val title = Random().nextInt(VALUE_100).toString()
            emit(title)
        }.flowOn(dispatcher)
}
