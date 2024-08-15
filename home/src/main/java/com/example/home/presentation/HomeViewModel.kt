package com.example.home.presentation

import com.example.core.presentation.StateAndEventViewModel
import com.example.home.presentation.state.HomeUIState
import com.example.home.presentation.uievent.HomeUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : StateAndEventViewModel<HomeUIState, HomeUIEvent>(HomeUIState()) {
    override suspend fun handleEvent(event: HomeUIEvent) {
       when (event) {
            HomeUIEvent.LoadInitialHome -> {
            }
            HomeUIEvent.Dismiss -> {
                updateUiState {
                    copy(
                        selectedProductItem = null
                    )
                }
            }

           is HomeUIEvent.OnBannerClicked -> TODO()
           is HomeUIEvent.OnProductClicked -> TODO()
           is HomeUIEvent.OnVerticalProductClicked -> TODO()
       }
    }
}