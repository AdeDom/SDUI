package com.adedom.adaptivecards.presentation.map

import androidx.compose.ui.Alignment
import com.adedom.adaptivecards.data.models.enumclass.ComponentPosition

fun ComponentPosition?.mapPosition(): Alignment {
    return when (this) {
        ComponentPosition.TOP_LEFT -> Alignment.TopStart
        ComponentPosition.TOP_CENTER -> Alignment.TopCenter
        ComponentPosition.TOP_RIGHT -> Alignment.TopEnd
        ComponentPosition.CENTER_LEFT -> Alignment.CenterStart
        ComponentPosition.CENTER -> Alignment.Center
        ComponentPosition.CENTER_RIGHT -> Alignment.CenterEnd
        ComponentPosition.BOTTOM_LEFT -> Alignment.BottomStart
        ComponentPosition.BOTTOM_CENTER -> Alignment.BottomCenter
        ComponentPosition.BOTTOM_RIGHT -> Alignment.BottomEnd
        ComponentPosition.TOP -> Alignment.TopCenter
        ComponentPosition.BOTTOM -> Alignment.BottomCenter
        ComponentPosition.LEFT -> Alignment.CenterStart
        ComponentPosition.RIGHT -> Alignment.CenterEnd
        null -> Alignment.Center
    }
}