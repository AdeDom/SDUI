package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

    AdaptiveCardContent(uiState.components)
}

@Composable
fun AdaptiveCardContent(components: List<Component>) {
    LazyColumn {
        items(components) { component ->
            UiComponentRender(component)
        }
    }
}

@Composable
fun UiComponentRender(component: Component) {
    when (component) {
//        is Component.ActionOpenUrl -> ActionOpenUrlText(component = component)
//        is Component.ActionShowCard -> ActionShowCardText(component = component)
//        is Component.ActionSubmit -> ActionSubmitText(component = component)
//        is Component.AdaptiveCard -> AdaptiveCardText(component = component)
//        is Component.Column -> ColumnText(component = component)
//        is Component.ColumnSet -> ColumnSetText(component = component)
//        is Component.FactSet -> FactSetText(component = component)
//        is Component.Image -> ImageText(component = component)
//        is Component.InputDate -> InputDateText(component = component)
//        is Component.InputText -> InputTextText(component = component)
        is Component.TextBlock -> TextBlockComponent(component = component)
        is Component.Banner -> BannerComponent(component = component)
        is Component.Text -> TextComponent(component = component)
//        is Component.Container -> ContainerText(component = component)
//        is Component.Cards -> CardsText(component = component)
//        is Component.Button -> ButtonText(component = component)
//        is Component.Badge -> BadgeText(component = component)
//        is Component.ActionOpenMore -> ActionOpenMoreText(component = component)
//        is Component.TextBadge -> TextBadgeText(component = component)
//        is Component.LazyHorizontal -> LazyHorizontalText(component = component)
        else -> {}
    }
}