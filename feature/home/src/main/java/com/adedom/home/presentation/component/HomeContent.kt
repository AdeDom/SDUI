package com.adedom.home.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adedom.home.presentation.event.HomeUiEvent
import com.adedom.home.presentation.state.HomeUiState
import com.adedom.ui_component.ui.component.text.AppText

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        LazyColumn {
            items(uiState.list) {
                AppText(
                    text = "${it.id}. ${it.text}",
                    fontSize = 32.sp,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .clickable {
                            onEvent(HomeUiEvent.OnClick(it))
                        }
                )
            }
        }
    }
}