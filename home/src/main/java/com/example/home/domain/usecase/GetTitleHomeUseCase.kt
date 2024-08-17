package com.example.home.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetTitleHomeUseCase {
    fun getTitleHome(): Flow<String>
}
