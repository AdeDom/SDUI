package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.ImageComponent
import com.adedom.ui_component.domain.models.ImageRowComponent

class ImageDataList : ArrayList<ImageData>()

data class ImageData(
    val number: Int?,
    val name: String?,
    val value: String?,
    val contentDescription: String?,
    val width: Int?,
    val height: Int?,
    val roundedCornerShape: Int?,
    val newEpisodes: String?
)


fun ImageDataList.toComponent(): ImageRowComponent {
    return ImageRowComponent(
        this.map {
            it.toComponent()
        }
    )
}

fun ImageData.toComponent(): ImageComponent {
    return ImageComponent(
        number = number,
        name = name,
        value = value
            ?: "https://play-lh.googleusercontent.com/0fP9JUiv-PKujKpuHXTY-AL8rEFS3uy2c4dAlBUYz8kTVMFktVCKq5dnvlQ42WwL7pQ",
        contentDescription = contentDescription,
        width = width,
        height = height ?: 100,
        roundedCornerShape = roundedCornerShape ?: 0,
        newEpisodes = newEpisodes
    )
}