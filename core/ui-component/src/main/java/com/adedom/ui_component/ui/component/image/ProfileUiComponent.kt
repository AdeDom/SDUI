package com.adedom.ui_component.ui.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.adedom.ui_component.R
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun ProfileUiComponent(
    modifier: Modifier = Modifier,
    value: String = "",
    contentDescription: String? = null
) {
    if (value.isBlank()) {
        Image(
            painterResource(id = R.drawable.bugaboo_inter),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(CircleShape)
        )
    } else {
        AsyncImage(
            model = value,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun ProfileUiComponentPreview() {
    SDUITheme {
        ProfileUiComponent()
    }
}