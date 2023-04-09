package com.adedom.ui_component.ui.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.adedom.ui_component.R
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun ImageUiComponent(
    modifier: Modifier = Modifier,
    value: String = "",
    contentDescription: String? = null,
    roundedCornerShape: Int = 0
) {
    if (value.isBlank()) {
        Image(
            painterResource(id = R.drawable.bugaboo_inter),
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(RoundedCornerShape(roundedCornerShape.dp))
        )
    } else {
        AsyncImage(
            model = value,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = modifier.clip(RoundedCornerShape(roundedCornerShape.dp))
        )
    }
}

@Preview
@Composable
fun ImageUiComponentPreview() {
    SDUITheme {
        ImageUiComponent()
    }
}