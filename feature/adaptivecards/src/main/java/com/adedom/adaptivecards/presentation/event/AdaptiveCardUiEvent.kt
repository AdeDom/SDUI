package com.adedom.adaptivecards.presentation.event

import com.adedom.adaptivecards.data.models.Component

sealed interface AdaptiveCardUiEvent {
    object Initial : AdaptiveCardUiEvent

    data class OnClick(
        val component: Component
    ) : AdaptiveCardUiEvent
}