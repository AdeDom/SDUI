package com.adedom.home.presentation.state

import com.adedom.home.domain.models.HomeModel

data class HomeUiState(
    val list: List<HomeModel> = emptyList()
)