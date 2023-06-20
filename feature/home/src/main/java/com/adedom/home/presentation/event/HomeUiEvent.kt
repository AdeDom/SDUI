package com.adedom.home.presentation.event

import com.adedom.home.domain.models.HomeModel

sealed interface HomeUiEvent {

    object Initial : HomeUiEvent

    data class OnClick(
        val value: HomeModel,
    ) : HomeUiEvent

}