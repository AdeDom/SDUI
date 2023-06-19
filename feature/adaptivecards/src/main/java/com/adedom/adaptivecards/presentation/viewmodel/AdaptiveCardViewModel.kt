package com.adedom.adaptivecards.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.adedom.adaptivecards.base.BaseViewModel
import com.adedom.adaptivecards.domain.usecase.GetSampleAdaptiveUseCase
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.state.AdaptiveCardUiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AdaptiveCardViewModel(
    private val getSampleAdaptiveUseCase: GetSampleAdaptiveUseCase,
) : BaseViewModel<AdaptiveCardUiEvent, AdaptiveCardUiState>(AdaptiveCardUiState()) {

    private val _onClick = Channel<Unit>()
    val onClick: Flow<Unit> = _onClick.receiveAsFlow()

    override fun onEvent(event: AdaptiveCardUiEvent) {
        viewModelScope.launch {
            when (event) {
                AdaptiveCardUiEvent.Initial -> {
                    emit {
                        copy(isLoading = true)
                    }
                    val components = getSampleAdaptiveUseCase.execute()
                    emit {
                        copy(
                            components = components,
                            isLoading = false
                        )
                    }
                }

                is AdaptiveCardUiEvent.OnClick -> {
                    _onClick.send(Unit)
                }
            }
        }
    }
}