package com.adedom.adaptivecards.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adedom.adaptivecards.data.datasource.remote.AdaptiveCardRemoteDataSource
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.state.AdaptiveCardUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AdaptiveCardViewModel(
    private val adaptiveCardRemoteDataSource: AdaptiveCardRemoteDataSource,
) : ViewModel() {

    var uiState by mutableStateOf(AdaptiveCardUiState())
        private set

    private val _onClick = Channel<Component>()
    val onClick: Flow<Component> = _onClick.receiveAsFlow()

    fun onEvent(event: AdaptiveCardUiEvent) {
        viewModelScope.launch {
            when (event) {
                AdaptiveCardUiEvent.Initial -> {
                    val response = adaptiveCardRemoteDataSource.getSampleAdaptive()
                    uiState = uiState.copy(components = response.body ?: emptyList())
                }

                is AdaptiveCardUiEvent.OnClick -> {
                    _onClick.send(event.component)
                }
            }
        }
    }
}