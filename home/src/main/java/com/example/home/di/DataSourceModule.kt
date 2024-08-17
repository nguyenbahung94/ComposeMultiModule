package com.example.home.di

import com.example.home.data.datasource.HomeService
import com.example.home.data.datasource.RemoteDataSource
import com.example.home.data.datasource.RemoveDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }

    @Singleton
    @Provides
    internal fun provideInitialDataSource(apiService: HomeService): RemoteDataSource {
        return RemoveDataSourceImpl(apiService)
    }
}
