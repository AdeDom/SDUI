package com.adedom.home.presentation.state

import com.adedom.ui_component.domain.models.UiComponent

data class HomeUiState(
    val uiComponents: List<UiComponent> = emptyList()
)