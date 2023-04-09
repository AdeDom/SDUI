package com.adedom.ui_component.ui.component.image

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.ui.component.text.TextNewEpisodesComponent
import com.adedom.ui_component.ui.component.text.TextTop10Component
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun ImageCardComponent(
    modifier: Modifier = Modifier,
    number: Int? = null,
    name: String? = null,
    value: String = "",
    contentDescription: String? = null,
    roundedCornerShape: Int = 0,
    newEpisodes: String? = null
) {
    Box {
        ImageUiComponent(
            value = value,
            contentDescription = contentDescription,
            roundedCornerShape = roundedCornerShape,
            modifier = modifier
        )

        newEpisodes?.let {
            TextNewEpisodesComponent(
                text = newEpisodes,
                modifier = Modifier.padding(4.dp)
            )
        }

        if (number != null && name != null) {
            TextTop10Component(
                number = number,
                name = name,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}

@Preview
@Composable
fun ImageCardComponentPreview() {
    SDUITheme {
        ImageCardComponent(newEpisodes = null)
    }
}

@Preview
@Composable
fun ImageCardComponentNewEpisodesPreview() {
    SDUITheme {
        ImageCardComponent(newEpisodes = "ตอนใหม่")
    }
}

@Preview
@Composable
fun ImageCardComponentTop10Preview() {
    SDUITheme {
        ImageCardComponent(
            number = 1,
            name = "ฮักหลายมายเลดี้"
        )
    }
}