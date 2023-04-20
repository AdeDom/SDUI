package com.adedom.adaptivecards.presentation.state

import com.adedom.adaptivecards.data.models.Component

data class AdaptiveCardUiState(
    val components: List<Component> = emptyList(),
)