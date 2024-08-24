package com.example.list.di

import com.example.list.data.datasource.ListDataSource
import com.example.list.data.domaincontract.usecase.GetListUseCaseImpl
import com.example.list.domain.usecase.GetListUseCase
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
    fun provideGetListUseCase(
        listDataSource: ListDataSource,
        dispatcher: CoroutineDispatcher,
    ): GetListUseCase {
        return GetListUseCaseImpl(listDataSource, dispatcher)
    }
}
