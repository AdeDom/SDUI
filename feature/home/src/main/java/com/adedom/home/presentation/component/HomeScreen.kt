package com.adedom.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adedom.home.domain.models.HomeModel
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigate: (HomeModel) -> Unit,
) {
    val uiState = viewModel.uiState

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeUiEvent.Initial)

        viewModel.nav.collect(onNavigate)
    }

    HomeContent(
        uiState = uiState,
        onEvent = viewModel::onEvent,
    )
}