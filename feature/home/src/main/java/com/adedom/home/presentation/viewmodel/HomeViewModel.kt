package com.adedom.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.adedom.home.data.repositories.HomeRepository
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.state.HomeUiState

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.Initial -> {
                uiState = uiState.copy(
                    uiComponents = homeRepository.getHome().components
                )
            }
        }
    }
}