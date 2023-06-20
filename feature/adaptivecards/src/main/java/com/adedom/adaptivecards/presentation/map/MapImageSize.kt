package com.adedom.adaptivecards.presentation.map

import androidx.compose.ui.Modifier
import io.adaptivecards.objectmodel.ImageSize

fun Modifier.mapImageSize(imageSize: ImageSize?): Modifier {
    return when (imageSize) {
        ImageSize.Auto -> this
        ImageSize.Stretch -> this
        ImageSize.Small -> this
        ImageSize.Medium -> this
        ImageSize.Large -> this
        ImageSize.None -> this
        null -> this
    }
}