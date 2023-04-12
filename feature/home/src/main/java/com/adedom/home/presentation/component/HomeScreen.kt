package com.adedom.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.viewmodel.HomeViewModel
import com.adedom.ui_component.ui.component.UiComponentsRender

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeUiEvent.Initial)
    }

    UiComponentsRender(uiComponents = viewModel.uiState.uiComponents)
}