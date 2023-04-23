package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component

@Composable
fun ContainerComponent(
    modifier: Modifier = Modifier,
    component: Component.Container
) {
    Box(modifier = modifier) {
        Column {
            component.items.forEach { component ->
                UiComponentRender(component = component)
            }
        }
    }
}