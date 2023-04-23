package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component

@Composable
fun ColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.Column,
) {
    Column(modifier = modifier) {
        component.items.forEach { component ->
            UiComponentRender(component = component)
        }
    }
}