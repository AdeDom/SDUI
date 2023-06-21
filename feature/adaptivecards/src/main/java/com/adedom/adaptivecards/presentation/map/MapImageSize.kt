package com.adedom.adaptivecards.presentation.map

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.adaptivecards.objectmodel.ImageSize

fun Modifier.mapImageSize(imageSize: ImageSize?, width: Int?, height: Int?): Modifier {
    return when (imageSize) {
        ImageSize.Auto -> size(width, height)
        ImageSize.Stretch -> size(width, height)
        ImageSize.Small -> size(width, height)
        ImageSize.Medium -> size(width, height)
        ImageSize.Large -> size(width, height)
        ImageSize.None -> size(width, height)
        null -> size(width, height)
    }
}

private fun Modifier.size(width: Int?, height: Int?): Modifier {
    return when {
        width != null && height != null -> this.size(width = width.dp, height = height.dp)
        width != null && height == null -> this.width(width = width.dp)
        width == null && height != null -> this.height(height = height.dp)
        else -> this
    }
}