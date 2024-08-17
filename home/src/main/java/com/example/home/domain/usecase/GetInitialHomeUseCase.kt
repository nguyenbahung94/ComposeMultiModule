package com.example.home.domain.usecase

import com.example.home.domain.model.HomeSection
import kotlinx.coroutines.flow.Flow

interface GetInitialHomeUseCase {
    fun getInitialHome(): Flow<HomeSection>
}
