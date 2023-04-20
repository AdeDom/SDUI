package com.adedom.adaptivecards.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adedom.adaptivecards.data.datasource.remote.AdaptiveCardRemoteDataSource
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.state.AdaptiveCardUiState
import kotlinx.coroutines.launch

class AdaptiveCardViewModel(
    private val adaptiveCardRemoteDataSource: AdaptiveCardRemoteDataSource,
) : ViewModel() {

    var uiState by mutableStateOf(AdaptiveCardUiState())
        private set

    fun onEvent(event: AdaptiveCardUiEvent) {
        viewModelScope.launch {
            when (event) {
                AdaptiveCardUiEvent.Initial -> {
                    val response = adaptiveCardRemoteDataSource.getSampleAdaptive()
                    uiState = uiState.copy(components = response.body ?: emptyList())
                }
            }
        }
    }
}