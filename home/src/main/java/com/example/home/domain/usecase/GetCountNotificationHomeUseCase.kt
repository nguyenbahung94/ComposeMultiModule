package com.example.home.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetCountNotificationHomeUseCase {
    fun getCountNotificationHome(): Flow<Int>
}
