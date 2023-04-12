package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.ImageComponent
import com.adedom.ui_component.domain.models.ImageRowComponent

data class ImageDataMaster(
    val id: Int?,
    val data: ImageData?
)

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

class ImageDataList : ArrayList<ImageDataMaster>()

fun ImageDataList.toComponent(): ImageRowComponent {
    return ImageRowComponent(
        this.map {
            it.toComponent()
        }
    )
}

fun ImageDataMaster.toComponent(): ImageComponent {
    return ImageComponent(
        id = id ?: -1,
        number = data?.number,
        name = data?.name,
        value = data?.value
            ?: "https://play-lh.googleusercontent.com/0fP9JUiv-PKujKpuHXTY-AL8rEFS3uy2c4dAlBUYz8kTVMFktVCKq5dnvlQ42WwL7pQ",
        contentDescription = data?.contentDescription,
        width = data?.width,
        height = data?.height ?: 100,
        roundedCornerShape = data?.roundedCornerShape ?: 0,
        newEpisodes = data?.newEpisodes
    )
}