package com.adedom.adaptivecards.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component

@Composable
fun UiComponentRender(
    modifier: Modifier = Modifier,
    component: Component,
    onClick: (Action) -> Unit
) {
    when (component) {
//        is Component.ActionOpenUrl -> ActionOpenUrlText(component = component)
//        is Component.ActionShowCard -> ActionShowCardText(component = component)
//        is Component.ActionSubmit -> ActionSubmitText(component = component)
//        is Component.AdaptiveCard -> AdaptiveCardText(component = component)
        is Component.Column -> ColumnComponent(modifier, component, onClick)
//        is Component.ColumnSet -> ColumnSetText(component = component)
//        is Component.FactSet -> FactSetText(component = component)
        is Component.Image -> ImageComponent(modifier, component)
//        is Component.InputDate -> InputDateText(component = component)
//        is Component.InputText -> InputTextText(component = component)
        is Component.TextBlock -> TextBlockComponent(modifier, component)
        is Component.Banner -> BannerComponent(modifier, component)
        is Component.Text -> TextComponent(modifier, component, onClick)
        is Component.Container -> ContainerComponent(modifier, component, onClick)
        is Component.Cards -> CardsComponent(modifier, component, onClick)
//        is Component.Button -> ButtonText(component = component)
//        is Component.Badge -> BadgeText(component = component)
//        is Component.ActionOpenMore -> ActionOpenMoreText(component = component)
//        is Component.TextBadge -> TextBadgeText(component = component)
        is Component.LazyHorizontal -> LazyHorizontalComponent(modifier, component, onClick)
        else -> {}
    }
}