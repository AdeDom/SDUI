package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component

@Composable
fun CardsComponent(
    modifier: Modifier = Modifier,
    component: Component.Cards,
    onClick: (Component) -> Unit
) {
    Card(modifier = modifier) {
        Column {
            component.items.forEach { component ->
                UiComponentRender(component = component, onClick = onClick)
            }
        }
    }
}