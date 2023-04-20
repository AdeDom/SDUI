package com.adedom.adaptivecards.presentation.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Component

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    component: Component.Text,
) {
    component.text?.let {
        Text(
            text = it,
            modifier = modifier,
        )
    }
}