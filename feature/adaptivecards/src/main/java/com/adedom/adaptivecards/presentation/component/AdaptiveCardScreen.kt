package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.viewmodel.AdaptiveCardViewModel

@Composable
fun AdaptiveCardScreen(
    viewModel: AdaptiveCardViewModel,
) {
    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(AdaptiveCardUiEvent.Initial)
    }

    LazyColumn {
        items(uiState.components) { component ->
            ComponentText(component = component)
        }
    }
}