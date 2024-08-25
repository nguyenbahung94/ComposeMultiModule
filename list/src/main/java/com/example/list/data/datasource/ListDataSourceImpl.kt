package com.example.list.data.datasource

import com.example.core.utils.handleCall
import javax.inject.Inject

internal class ListDataSourceImpl @Inject constructor(
    private val listService: ListService,
) : ListDataSource {

    override suspend fun getList() = handleCall {
        listService.getList()
    }
}
