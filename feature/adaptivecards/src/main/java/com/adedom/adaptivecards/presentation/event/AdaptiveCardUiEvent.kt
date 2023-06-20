package com.adedom.adaptivecards.presentation.event

import com.adedom.adaptivecards.data.models.Action

sealed interface AdaptiveCardUiEvent {

    data class Initial(
        val id: Int?
    ) : AdaptiveCardUiEvent

    data class OnClick(
        val action: Action?
    ) : AdaptiveCardUiEvent
}