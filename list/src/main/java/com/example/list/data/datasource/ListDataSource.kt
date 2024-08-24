package com.example.list.data.datasource

import com.example.list.data.datasource.model.ListResponse

interface ListDataSource {
    suspend fun getList(): ListResponse
}
