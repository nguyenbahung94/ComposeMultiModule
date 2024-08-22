package com.example.detail.di

import com.example.detail.data.datasource.RemoteDataSource
import com.example.detail.data.domaincontract.usecase.GetItemDetailUseCaseImpl
import com.example.detail.domain.usecase.GetItemDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetItemDetailUseCase(
        dataSource: RemoteDataSource,
        dispatcher: CoroutineDispatcher,
    ): GetItemDetailUseCase {
        return GetItemDetailUseCaseImpl(dataSource, dispatcher)
    }
}
