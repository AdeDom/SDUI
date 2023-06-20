package com.adedom.adaptivecards.presentation.map

import androidx.compose.ui.Modifier
import com.adedom.adaptivecards.data.models.enumclass.ImageSize

fun Modifier.mapImageSize(imageSize: ImageSize?): Modifier {
    return when (imageSize) {
        ImageSize.AUTO -> this
        ImageSize.STRETCH -> this
        ImageSize.SMALL -> this
        ImageSize.MEDIUM -> this
        ImageSize.LARGE -> this
        null -> this
    }
}