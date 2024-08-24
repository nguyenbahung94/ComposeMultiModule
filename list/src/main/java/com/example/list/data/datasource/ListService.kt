package com.example.list.data.datasource

import com.example.list.data.datasource.model.ListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListService {

    @GET("/basaransuleyman/suleyman-basaranoglu-json/main/list-page-paging-first")
    suspend fun getList(): Response<ListResponse>
}
