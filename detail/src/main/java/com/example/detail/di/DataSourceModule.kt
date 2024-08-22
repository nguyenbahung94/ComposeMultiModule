package com.example.detail.di

import com.example.detail.data.datasource.DetailService
import com.example.detail.data.datasource.RemoteDataSource
import com.example.detail.data.datasource.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): DetailService {
        return retrofit.create(DetailService::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(service: DetailService): RemoteDataSource {
        return RemoteDataSourceImpl(service)
    }
}
