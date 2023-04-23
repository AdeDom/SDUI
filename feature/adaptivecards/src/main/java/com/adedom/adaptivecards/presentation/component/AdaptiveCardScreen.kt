package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.presentation.event.AdaptiveCardUiEvent
import com.adedom.adaptivecards.presentation.viewmodel.AdaptiveCardViewModel

@Composable
fun AdaptiveCardScreen(
    viewModel: AdaptiveCardViewModel,
    onClick: (Component) -> Unit
) {
    val uiState = viewModel.uiState

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(AdaptiveCardUiEvent.Initial)

        viewModel.onClick.collect(onClick)
    }

    AdaptiveCardContent(
        components = uiState.components,
        onClick = { component ->
            viewModel.onEvent(AdaptiveCardUiEvent.OnClick(component))
        }
    )
}

@Composable
fun AdaptiveCardContent(components: List<Component>, onClick: (Component) -> Unit) {
    LazyColumn {
        items(components) { component ->
            UiComponentRender(
                component = component,
                modifier = Modifier.clickable(onClick = { onClick(component) })
            )
        }
    }
}

@Composable
fun UiComponentRender(modifier: Modifier = Modifier, component: Component) {
    when (component) {
//        is Component.ActionOpenUrl -> ActionOpenUrlText(component = component)
//        is Component.ActionShowCard -> ActionShowCardText(component = component)
//        is Component.ActionSubmit -> ActionSubmitText(component = component)
//        is Component.AdaptiveCard -> AdaptiveCardText(component = component)
        is Component.Column -> ColumnComponent(modifier = modifier, component = component)
//        is Component.ColumnSet -> ColumnSetText(component = component)
//        is Component.FactSet -> FactSetText(component = component)
        is Component.Image -> ImageComponent(modifier = modifier, component = component)
//        is Component.InputDate -> InputDateText(component = component)
//        is Component.InputText -> InputTextText(component = component)
        is Component.TextBlock -> TextBlockComponent(modifier = modifier, component = component)
        is Component.Banner -> BannerComponent(modifier = modifier, component = component)
        is Component.Text -> TextComponent(modifier = modifier, component = component)
        is Component.Container -> ContainerComponent(modifier = modifier, component = component)
        is Component.Cards -> CardsComponent(modifier = modifier, component = component)
//        is Component.Button -> ButtonText(component = component)
//        is Component.Badge -> BadgeText(component = component)
//        is Component.ActionOpenMore -> ActionOpenMoreText(component = component)
//        is Component.TextBadge -> TextBadgeText(component = component)
        is Component.LazyHorizontal -> LazyHorizontalComponent(modifier = modifier, component = component)
        else -> {}
    }
}