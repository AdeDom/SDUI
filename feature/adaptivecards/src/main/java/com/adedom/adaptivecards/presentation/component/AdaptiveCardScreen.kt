package com.adedom.adaptivecards.presentation.component

import androidx.compose.material.Text
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

    Text(text = "Hello, ${uiState.adaptiveCardResponse?.version}")
}