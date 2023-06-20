package com.adedom.adaptivecards.presentation.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.adedom.adaptivecards.data.models.enumclass.ComponentAlign
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight

@Composable
fun ComponentSize.mapComponent(): TextUnit {
    return when (this) {
        ComponentSize.AUTO -> MaterialTheme.typography.bodyLarge.fontSize
        ComponentSize.STRETCH -> MaterialTheme.typography.bodyLarge.fontSize
        ComponentSize.SMALL -> MaterialTheme.typography.bodySmall.fontSize
        ComponentSize.MEDIUM -> MaterialTheme.typography.bodyMedium.fontSize
        ComponentSize.LARGE -> MaterialTheme.typography.bodyLarge.fontSize
    }
}

@Composable
fun ComponentWeight.mapComponent(): FontWeight {
    return when (this) {
        ComponentWeight.BOLDER -> FontWeight.Bold
        ComponentWeight.LIGHTER -> FontWeight.Light
    }
}

@Composable
fun ComponentAlign.mapComponent(): TextAlign {
    return when (this) {
        ComponentAlign.LEFT -> TextAlign.Left
        ComponentAlign.CENTER -> TextAlign.Center
    }
}

@Composable
fun ComponentStyle.mapComponent(): Shape {
    return when (this) {
        ComponentStyle.PERSON -> RoundedCornerShape(0.dp)
        ComponentStyle.BORDER -> RoundedCornerShape(0.dp)
        ComponentStyle.BORDER_TOP -> RoundedCornerShape(0.dp)
        ComponentStyle.TOP10 -> RoundedCornerShape(0.dp)
        ComponentStyle.CIRCLE -> CircleShape
        ComponentStyle.TOP_RIGHT -> RoundedCornerShape(0.dp)
        ComponentStyle.CARD -> RoundedCornerShape(0.dp)
    }
}