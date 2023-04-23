package com.adedom.adaptivecards.presentation.state

import com.adedom.adaptivecards.data.models.Component

data class AdaptiveCardUiState(
    val isLoading: Boolean = false,
    val components: List<Component> = emptyList(),
)