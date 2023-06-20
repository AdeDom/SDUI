package com.adedom.adaptivecards.presentation.component

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.adedom.adaptivecards.data.models.Action
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.adedom.adaptivecards.utils.extensions.clickable

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    component: Component.Text,
    onClick: (Action) -> Unit,
) {
    Surface(
        modifier = modifier.clickable(
            action = component.selectAction,
            onClick = onClick
        )
    ) {
        Text(
            text = component.text.orEmpty(),
            color = Color(android.graphics.Color.parseColor(component.color)),
            fontSize = (component.size ?: ComponentSize.MEDIUM).mapComponent(),
            fontWeight = (component.weight ?: ComponentWeight.LIGHTER).mapComponent(),
            textAlign = component.align?.mapComponent(),
        )
    }
}