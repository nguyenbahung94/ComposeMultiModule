package com.example.home.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.navigation.NavigationService
import com.example.core.presentation.StateAndEventViewModel
import com.example.home.domain.model.ProductItem
import com.example.home.domain.usecase.GetInitialHomeUseCase
import com.example.home.presentation.state.HomeUIState
import com.example.home.presentation.uievent.HomeUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getInitialHomeUseCase: GetInitialHomeUseCase,
    private val navigator: NavigationService,
) : StateAndEventViewModel<HomeUIState, HomeUIEvent>(HomeUIState()) {
    override suspend fun handleEvent(event: HomeUIEvent) {
        when (event) {
            HomeUIEvent.LoadInitialHome -> {
                getInitialHome()
            }

            HomeUIEvent.Dismiss -> {
                handleBack()
            }

            is HomeUIEvent.OnBannerClicked -> {
                onBannerClicked()
            }

            is HomeUIEvent.OnProductClicked -> {
                onProductClicked()
            }
            is HomeUIEvent.OnVerticalProductClicked -> {
                onVerticalProductClicked(event.item)
            }
        }
    }

    private fun onBannerClicked() {
        navigator.navigateTo("list")
    }

    private fun onVerticalProductClicked(productItem: ProductItem) {
        updateUiState { copy(selectedProductItem = productItem) }
    }

    private fun onProductClicked() {
        navigator.navigateTo("detailgraph") {
            launchSingleTop = true
            restoreState = true
        }
    }

    private fun handleBack() {
        navigator.goBack()
    }

    private fun getInitialHome() {
        HomeUIEvent.LoadInitialHome
        viewModelScope.launch {
            getInitialHomeUseCase.getInitialHome()
                .onStart {
                    updateUiState { copy(isLoading = true) }
                }
                .catch { error ->
                    updateUiState { copy(error = error) }
                }
                .collect { homeSection ->
                    Log.e("HomeViewModel", "getInitialHome: collect: $homeSection")
                    updateUiState {
                        copy(
                            homeData = homeSection,
                            isLoading = false,
                            error = null,
                            selectedProductItem = null,
                        )
                    }
                }
        }
    }
}
