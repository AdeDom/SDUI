package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.utils.extensions.clickable

@Composable
fun ColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.Column,
    onClick: (Component) -> Unit
) {
    Column(
        modifier = modifier.clickable(
            component = component,
            action = component.selectAction,
            onClick = onClick
        )
    ) {
        component.items.forEach { component ->
            UiComponentRender(component = component, onClick = onClick)
        }
    }
}