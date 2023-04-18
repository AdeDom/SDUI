package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adedom.adaptivecards.data.models.Component
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
        itemsIndexed(uiState.adaptiveCardResponse?.body ?: emptyList()) { index, component ->
            when (component) {
                is Component.ColumnSet -> {
                    Column {
                        Text(text = "index :: $index")
                        Text(text = component.type?.value.toString())
                    }
                }

                is Component.FactSet -> {
                    Column {
                        Text(text = "index :: $index")
                        Text(text = component.type?.value.toString())
                    }
                }

                is Component.TextBlock -> {
                    val data = """
                        type : ${component.type?.value},
                        size : ${component.size?.value},
                        weight : ${component.weight?.value},
                        text : ${component.text},
                        wrap : ${component.wrap},
                    """.trimIndent()
                    Column {
                        Text(text = "index :: $index")
                        Text(text = data)
                    }
                }
            }
        }
    }
}