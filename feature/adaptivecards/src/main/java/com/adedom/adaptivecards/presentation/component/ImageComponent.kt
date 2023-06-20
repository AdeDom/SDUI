package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.presentation.map.mapImageSize

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    component: Component.Image,
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = component.url,
            contentDescription = null,
            modifier = Modifier.mapImageSize(component.size)
        )
    }
}