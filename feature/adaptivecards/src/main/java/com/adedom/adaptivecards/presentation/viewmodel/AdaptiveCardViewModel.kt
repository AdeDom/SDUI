package com.adedom.adaptivecards.presentation.viewmodel

import com.adedom.adaptivecards.base.BaseViewModel
import com.adedom.adaptivecards.data.models.Component
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

    private val _onClick = Channel<Component>()
    val onClick: Flow<Component> = _onClick.receiveAsFlow()

    override fun onEvent(event: AdaptiveCardUiEvent) {
        launch {
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
                    _onClick.send(event.component)
                }
            }
        }
    }
}