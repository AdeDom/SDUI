package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

    UiComponent(uiState.adaptiveCardResponse?.body ?: emptyList())
}

@Composable
fun UiComponent(components: List<Component>) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        components.forEach { component ->
            when (component) {
                is Component.Column -> {
                    Text(text = component.type?.value.toString())
                }

                is Component.ColumnSet -> {
                    Column {
                        Text(text = component.type?.value.toString())
                        component.columns.forEach {
                            val data = """
                                type : ${it.type}
                            """.trimIndent()
                            Text(text = data)
                        }
                    }
                }

                is Component.FactSet -> {
                    Text(text = component.type?.value.toString())
                }

                is Component.TextBlock -> {
                    val data = """
                        type : ${component.type?.value}
                        size : ${component.size?.value}
                        weight : ${component.weight?.value}
                        text : ${component.text}
                        wrap : ${component.wrap}
                    """.trimIndent()
                    Text(text = data)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Black)
            )
        }
    }
}