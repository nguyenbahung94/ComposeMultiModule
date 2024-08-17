package com.example.home.data.datasource

import com.example.home.data.datasource.model.CountNotificationResponse
import com.example.home.data.datasource.model.HomeResponse
import com.example.home.data.datasource.model.TitleResponse
import com.example.network.extensions.handleCall
import javax.inject.Inject

internal class RemoveDataSourceImpl @Inject constructor(
    private val api: HomeService,
) : RemoteDataSource {

    override suspend fun getHome(): HomeResponse {
        return handleCall {
            api.getHome()
        }
    }

    override suspend fun getTitleHome(): TitleResponse {
        // asume this is correct endpoint
        return handleCall {
            api.getTitleHome()
        }
    }

    override suspend fun getCountNotificationHome(): CountNotificationResponse {
        // asume this is correct endpoint
        return handleCall {
            api.getCountNotificationHome()
        }
    }
}
