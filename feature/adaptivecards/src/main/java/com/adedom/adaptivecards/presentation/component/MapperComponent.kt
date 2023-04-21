package com.adedom.adaptivecards.presentation.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight

@Composable
fun ComponentSize.mapComponent(): TextUnit {
    return when (this) {
        ComponentSize.LARGE -> MaterialTheme.typography.bodyLarge.fontSize
        ComponentSize.MEDIUM -> MaterialTheme.typography.bodyMedium.fontSize
        ComponentSize.SMALL -> MaterialTheme.typography.bodySmall.fontSize
    }
}

@Composable
fun ComponentWeight.mapComponent(): FontWeight {
    return when (this) {
        ComponentWeight.BOLDER -> FontWeight.Bold
        ComponentWeight.LIGHTER -> FontWeight.Light
    }
}