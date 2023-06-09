package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component

@Composable
fun ContainerComponent(
    modifier: Modifier = Modifier,
    component: Component.Container,
    onClick: (Action) -> Unit
) {
    Surface(modifier = modifier) {
        Column {
            component.items?.forEach { component ->
                UiComponentRender(component = component, onClick = onClick)
            }
        }
    }
}