package com.example.detail.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.components.ErrorComponent
import com.example.core.components.LoadingComponent
import com.example.detail.presentation.components.DetailContent
import com.example.detail.presentation.uievent.DetailUIEvent

@Composable
fun DetailScreen() {
    val viewModel = hiltViewModel<DetailViewModel>()
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(true) {
        viewModel.onEvent(DetailUIEvent.LoadItemDetail)
    }

    when {
        state.isLoading -> {
            LoadingComponent()
        }
        state.error != null -> {
            ErrorComponent(error = state.error)
        }
        state.itemData != null -> {
            DetailContent(
                itemData = state.itemData!!,
                onSearchClicked = { viewModel.onEvent(DetailUIEvent.SearchDetailClick) },
            )
        }
    }
}
