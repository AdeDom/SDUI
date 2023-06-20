package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component

@Composable
fun LazyHorizontalComponent(
    modifier: Modifier = Modifier,
    component: Component.LazyHorizontal,
    onClick: (Action) -> Unit
) {
    Box(modifier = modifier) {
        LazyRow {
            items(component.columns ?: emptyList()) { component ->
                UiComponentRender(component = component, onClick = onClick)
            }
        }
    }
}