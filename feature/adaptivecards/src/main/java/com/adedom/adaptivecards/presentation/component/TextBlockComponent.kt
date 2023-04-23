package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight

@Composable
fun TextBlockComponent(
    modifier: Modifier = Modifier,
    component: Component.TextBlock,
) {
    component.text?.let {
        Text(
            text = it,
            fontSize = (component.size ?: ComponentSize.MEDIUM).mapComponent(),
            fontWeight = (component.weight ?: ComponentWeight.LIGHTER).mapComponent(),
            modifier = modifier.padding(16.dp),
        )
    }
}