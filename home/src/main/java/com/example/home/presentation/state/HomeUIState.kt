package com.example.home.presentation.state

import androidx.compose.runtime.Immutable
import com.example.home.domain.model.HomeSection
import com.example.home.domain.model.ProductItem

@Immutable
data class HomeUIState(
    val isLoading: Boolean = false,
    val homeData: HomeSection? = null,
    val error: Throwable? = null,
    val selectedProductItem: ProductItem? = null,
)
