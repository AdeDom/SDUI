package com.adedom.adaptivecards.presentation.event

import com.adedom.adaptivecards.data.models.Action

sealed interface AdaptiveCardUiEvent {

    object Initial : AdaptiveCardUiEvent

    data class OnClick(
        val action: Action?
    ) : AdaptiveCardUiEvent
}