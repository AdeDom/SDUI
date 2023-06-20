package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.utils.extensions.clickable

@Composable
fun ColumnSetComponent(
    modifier: Modifier = Modifier,
    component: Component.ColumnSet,
    onClick: (Action) -> Unit
) {
    Row(
        modifier = modifier.clickable(
            action = component.selectAction,
            onClick = onClick
        )
    ) {
        component.columns?.forEach { component ->
            UiComponentRender(component = component, onClick = onClick)
        }
    }
}