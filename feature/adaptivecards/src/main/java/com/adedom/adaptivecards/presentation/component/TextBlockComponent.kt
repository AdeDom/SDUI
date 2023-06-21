package com.adedom.adaptivecards.presentation.component

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.utils.extensions.clickable

@Composable
fun TextBlockComponent(
    modifier: Modifier = Modifier,
    component: Component.TextBlock,
    onClick: (Action) -> Unit
) {
    Surface(
        modifier = modifier.clickable(
            action = component.selectAction,
            onClick = onClick
        )
    ) {
        Text(
            text = component.text.orEmpty(),
        )
    }
}