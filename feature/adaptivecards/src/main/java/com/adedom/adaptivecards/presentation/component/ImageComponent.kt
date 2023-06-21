package com.adedom.adaptivecards.presentation.component

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.presentation.map.mapImageSize
import com.adedom.adaptivecards.utils.extensions.clickable

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    component: Component.Image,
    onClick: (Action) -> Unit
) {
    Surface(
        modifier = modifier.clickable(
            action = component.selectAction,
            onClick = onClick
        )
    ) {
        AsyncImage(
            model = component.url,
            contentDescription = null,
            modifier = Modifier.mapImageSize(component.size)
        )
    }
}