package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adedom.adaptivecards.data.models.Component
import com.adedom.ui_component.ui.theme.Typography

@Composable
fun BannerComponent(
    modifier: Modifier = Modifier,
    component: Component.Banner
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = component.url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxSize()
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(32.dp)
        ) {
            component.info?.title?.let {
                Text(
                    text = it,
                    style = Typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            component.info?.description?.let {
                Text(
                    text = it,
                    style = Typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}