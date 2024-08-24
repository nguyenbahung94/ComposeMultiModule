package com.example.list.di

import com.example.list.data.datasource.ListDataSource
import com.example.list.data.datasource.ListDataSourceImpl
import com.example.list.data.datasource.ListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatSourceModule {

    @Provides
    @Singleton
    fun provideListService(retrofit: Retrofit): ListService {
        return retrofit.create(ListService::class.java)
    }

    @Provides
    @Singleton
    fun provideListDataSource(listService: ListService): ListDataSource {
        return ListDataSourceImpl(listService)
    }
}
