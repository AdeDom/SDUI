package com.adedom.adaptivecards.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.adedom.adaptivecards.base.BaseViewModel
import com.adedom.adaptivecards.data.models.Action
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

    private val _onClick = Channel<Action>()
    val onClick: Flow<Action> = _onClick.receiveAsFlow()

    override fun onEvent(event: AdaptiveCardUiEvent) {
        viewModelScope.launch {
            when (event) {
                is AdaptiveCardUiEvent.Initial -> {
                    try {
                        emit {
                            copy(isLoading = true)
                        }
                        val components = getSampleAdaptiveUseCase.execute(event.id)
                        emit {
                            copy(
                                components = components,
                                isLoading = false
                            )
                        }
                    } catch (e: Throwable) {
                        emit {
                            copy(isLoading = false)
                        }
                    }
                }

                is AdaptiveCardUiEvent.OnClick -> {
                    event.action?.let {
                        _onClick.send(event.action)
                    }
                }
            }
        }
    }
}