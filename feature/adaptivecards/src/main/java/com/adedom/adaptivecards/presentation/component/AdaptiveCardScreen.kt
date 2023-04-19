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
import com.adedom.adaptivecards.data.models.AdaptiveCardResponse
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

    AdaptiveCardContent(uiState.adaptiveCardResponse)
}

@Composable
fun AdaptiveCardContent(adaptiveCardResponse: AdaptiveCardResponse?) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        adaptiveCardResponse?.body?.forEach { ComponentText(it) }
        adaptiveCardResponse?.actions?.forEach { ComponentText(it) }
    }
}

@Composable
fun ComponentText(component: Component) {
    when (component) {
        is Component.ActionOpenUrl -> ActionOpenUrlText(component)
        is Component.ActionShowCard -> ActionShowCardText(component)
        is Component.AdaptiveCard -> AdaptiveCardText(component)
        is Component.Column -> ColumnText(component)
        is Component.ColumnSet -> ColumnSetText(component)
        is Component.FactSet -> FactSetText(component)
        is Component.Image -> ImageText(component)
        is Component.TextBlock -> TextBlockText(component)
    }
}

@Composable
fun ActionOpenUrlText(component: Component.ActionOpenUrl) {
    Column {
        component.type?.let { Text(it.value) }
        component.title?.let { Text(it) }
        component.url?.let { Text(it) }
        Line()
    }
}

@Composable
fun ActionShowCardText(component: Component.ActionShowCard) {
    Column {
        component.type?.let { Text(it.value) }
        component.title?.let { Text(it) }
        component.card?.let { AdaptiveCardText(it) }
        Line()
    }
}

@Composable
fun AdaptiveCardText(component: Component.AdaptiveCard) {
    Column {
        component.type?.let { Text(it.value) }
        component.schema?.let { Text(it) }
        Line()
    }
}

@Composable
fun ColumnText(component: Component.Column) {
    Column {
        component.type?.let { Text(it.value) }
        component.items.forEach { ComponentText(it) }
        component.width?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun ColumnSetText(component: Component.ColumnSet) {
    Column {
        component.type?.let { Text(it.value) }
        component.columns.forEach { ComponentText(it) }
        Line()
    }
}

@Composable
fun FactSetText(component: Component.FactSet) {
    Column {
        component.type?.let { Text(it.value) }
        component.facts.forEach { fact ->
            fact.data?.let { Text(it) }
            fact.title?.let { Text(it) }
            fact.value?.let { Text(it) }
        }
        Line()
    }
}

@Composable
fun ImageText(component: Component.Image) {
    Column {
        component.type?.let { Text(it.value) }
        component.style?.let { Text(it.value) }
        component.url?.let { Text(it) }
        component.size?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun TextBlockText(component: Component.TextBlock) {
    Column {
        component.type?.let { Text(it.value) }
        component.size?.let { Text(it.value) }
        component.weight?.let { Text(it.value) }
        component.spacing?.let { Text(it.value) }
        component.text?.let { Text(it) }
        component.isSubtle?.let { Text(it.toString()) }
        component.wrap?.let { Text(it.toString()) }
        Line()
    }
}

@Composable
fun Line() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Black)
    )
}