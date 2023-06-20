package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component

@Composable
fun LazyColumnComponent(
    modifier: Modifier = Modifier,
    component: Component.LazyColumn,
    onClick: (Action) -> Unit
) {
    Box(modifier = modifier) {
        LazyColumn {
            items(component.body ?: emptyList()) { component ->
                UiComponentRender(component = component, onClick = onClick)
            }
        }
    }
}