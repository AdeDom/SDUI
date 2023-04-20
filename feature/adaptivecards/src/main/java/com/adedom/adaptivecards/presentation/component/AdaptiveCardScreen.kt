package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

    LazyColumn {
        items(uiState.components) {
            ComponentText(it)
        }
    }
}

@Composable
fun AdaptiveCardContent(component: Component?) {
    Column(Modifier.verticalScroll(rememberScrollState())) {
        component?.let { ComponentText(it) }
    }
}

@Composable
fun ComponentText(component: Component) {
    when (component) {
        is Component.ActionOpenUrl -> ActionOpenUrlText(component)
        is Component.ActionShowCard -> ActionShowCardText(component)
        is Component.ActionSubmit -> ActionSubmitText(component)
        is Component.AdaptiveCard -> AdaptiveCardText(component)
        is Component.Column -> ColumnText(component)
        is Component.ColumnSet -> ColumnSetText(component)
        is Component.FactSet -> FactSetText(component)
        is Component.Image -> ImageText(component)
        is Component.InputDate -> InputDateText(component)
        is Component.InputText -> InputTextText(component)
        is Component.TextBlock -> TextBlockText(component)
        is Component.Banner -> BannerText(component)
        is Component.Text -> TextText(component)
        is Component.Container -> ContainerText(component)
        is Component.Cards -> CardsText(component)
        is Component.Button -> ButtonText(component)
        is Component.Badge -> BadgeText(component)
        is Component.ActionOpenMore -> ActionOpenMoreText(component)
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
fun ActionSubmitText(component: Component.ActionSubmit) {
    Column {
        component.type?.let { Text(it.value) }
        component.title?.let { Text(it) }
    }
}

@Composable
fun AdaptiveCardText(component: Component.AdaptiveCard) {
    Column {
        component.type?.let { Text(it.value) }
        component.body.forEach { ComponentText(it) }
        component.actions.forEach { ComponentText(it) }
        component.schema?.let { Text(it) }
        component.version?.let { Text(it) }
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
        component.info?.let { Text(it.toString()) }
        component.ratio?.let { Text(it) }
        component.column?.let { Text(it.toString()) }
        component.overlays.forEach { ComponentText(it) }
        component.items.forEach { ComponentText(it) }
        component.images.forEach { Text(it) }
        Line()
    }
}

@Composable
fun InputDateText(component: Component.InputDate) {
    Column {
        component.type?.let { Text(it.value) }
        component.id?.let { Text(it) }
    }
}

@Composable
fun InputTextText(component: Component.InputText) {
    Column {
        component.type?.let { Text(it.value) }
        component.id?.let { Text(it) }
        component.placeholder?.let { Text(it) }
        component.isMultiline?.let { Text(it.toString()) }
    }
}

@Composable
fun TextBlockText(component: Component.TextBlock) {
    Column {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
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
fun BannerText(component: Component.Banner) {
    Column {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
        component.info?.let { Text(it.toString()) }
        component.url?.let { Text(it) }
        component.items.forEach { ComponentText(it) }
        Line()
    }
}

@Composable
fun TextText(component: Component.Text) {
    Column {
        component.type?.let { Text(it.value) }
        component.index?.let { Text(it.toString()) }
        component.text?.let { Text(it) }
        component.size?.let { Text(it.value) }
        component.color?.let { Text(it) }
        component.weight?.let { Text(it.value) }
        component.align?.let { Text(it.value) }
        component.spacing?.let { Text(it.value) }
        component.selectAction?.let { ComponentText(it) }
        component.maxLines?.let { Text(it.toString()) }
        Line()
    }
}

@Composable
fun ContainerText(component: Component.Container) {
    Column {
        component.type?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun CardsText(component: Component.Cards) {
    Column {
        component.type?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun ButtonText(component: Component.Button) {
    Column {
        component.type?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun BadgeText(component: Component.Badge) {
    Column {
        component.type?.let { Text(it.value) }
        Line()
    }
}

@Composable
fun ActionOpenMoreText(component: Component.ActionOpenMore) {
    Column {
        component.type?.let { Text(it.value) }
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