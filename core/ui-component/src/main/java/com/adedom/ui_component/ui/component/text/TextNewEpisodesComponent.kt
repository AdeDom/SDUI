package com.adedom.ui_component.ui.component.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adedom.ui_component.ui.theme.SDUITheme

@Composable
fun TextNewEpisodesComponent(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(modifier) {
        Text(
            text = text,
            modifier = Modifier
                .clip(RoundedCornerShape(2.dp))
                .background(Color.Yellow)
                .padding(2.dp)
        )
    }
}

@Preview
@Composable
fun TextNewEpisodesComponentPreview() {
    SDUITheme {
        TextNewEpisodesComponent(text = "ตอนใหม่")
    }
}