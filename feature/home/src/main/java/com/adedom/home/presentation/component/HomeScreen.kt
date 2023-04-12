package com.adedom.home.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.viewmodel.HomeViewModel
import com.adedom.ui_component.domain.models.AppDialogComponent
import com.adedom.ui_component.ui.component.UiComponentsRender
import com.adedom.ui_component.ui.component.dialog.AppErrorDialogComponent

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onNavigateToDetail: (String) -> Unit,
) {
    val uiState = viewModel.uiState

    LaunchedEffect(Unit) {
        viewModel.onEvent(HomeUiEvent.Initial)

        viewModel.nav.collect {
            onNavigateToDetail(it)
        }
    }

    UiComponentsRender(
        uiComponents = uiState.uiComponents,
        onClick = {
            viewModel.onEvent(HomeUiEvent.OnClickMovieListener(it))
        }
    )

    when (uiState.dialog) {
        AppDialogComponent.EmptyData -> {
            AppErrorDialogComponent {
                viewModel.onEvent(HomeUiEvent.OnClickHideDialogListener)
            }
        }
        null -> {}
    }
}