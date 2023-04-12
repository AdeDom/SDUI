package com.adedom.movie.presentation.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.ui_component.ui.component.text.AppText

@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    text: String?,
) {
    AppText(
        text = "Hello, Movie - $text",
        modifier = modifier
    )
}