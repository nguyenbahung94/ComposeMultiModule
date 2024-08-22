package com.example.home.di

import com.example.home.data.datasource.RemoteDataSource
import com.example.home.data.domaincontract.usecase.GetCountNotificationHomeUseCaseImpl
import com.example.home.data.domaincontract.usecase.GetInitialHomeUseCaseImpl
import com.example.home.data.domaincontract.usecase.GetTitleHomeUseCaseImpl
import com.example.home.domain.usecase.GetCountNotificationHomeUseCase
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.domain.usecase.GetTitleHomeUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetInitialHomeUseCase(
        dataSource: RemoteDataSource,
        dispatcher: CoroutineDispatcher,
    ): GetInitialHomeUseCase = GetInitialHomeUseCaseImpl(dataSource, dispatcher)

    @Provides
    @Singleton
    fun provideGetTitleHomeUseCase(
        dataSource: RemoteDataSource,
        dispatcher: CoroutineDispatcher,
    ): GetTitleHomeUseCase = GetTitleHomeUseCaseImpl(dataSource, dispatcher)

    @Provides
    @Singleton
    fun provideGetCountNotificationHomeUseCase(
        dataSource: RemoteDataSource,
        dispatcher: CoroutineDispatcher,
    ): GetCountNotificationHomeUseCase = GetCountNotificationHomeUseCaseImpl(dataSource, dispatcher)
}
