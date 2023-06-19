package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.state.AdaptiveCardUiState
import com.adedom.adaptivecards.presentation.viewmodel.AdaptiveCardViewModel

@Composable
fun AdaptiveCardScreen(
    modifier: Modifier = Modifier,
    viewModel: AdaptiveCardViewModel,
    id: Int? = null,
    onClick: (Action) -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(AdaptiveCardUiEvent.Initial(id))

        viewModel.onClick.collect(onClick)
    }

    AdaptiveCardContent(
        modifier = modifier,
        state = viewModel.uiState,
        onEvent = viewModel::onEvent,
    )
}

@Composable
fun AdaptiveCardContent(
    modifier: Modifier = Modifier,
    state: AdaptiveCardUiState,
    onEvent: (AdaptiveCardUiEvent) -> Unit,
) {
    Box(modifier = modifier) {
        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }

        LazyColumn {
            items(state.components) { component ->
                UiComponentRender(
                    component = component,
                    onClick = { action ->
                        onEvent(AdaptiveCardUiEvent.OnClick(action))
                    }
                )
            }
        }
    }
}