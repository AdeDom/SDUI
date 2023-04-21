package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle

@Composable
fun ImageComponent(
    modifier: Modifier = Modifier,
    component: Component.Image,
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = component.url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip((component.style ?: ComponentStyle.BORDER).mapComponent())
        )
    }
}