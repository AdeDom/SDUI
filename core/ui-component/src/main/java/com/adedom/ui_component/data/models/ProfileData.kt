package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.ProfileComponent
import com.adedom.ui_component.domain.models.ProfileRowComponent

class ProfileDataList : ArrayList<ProfileData>()

data class ProfileData(
    val number: Int?,
    val name: String?,
    val value: String?,
    val contentDescription: String?,
    val width: Int?,
    val height: Int?,
    val roundedCornerShape: Int?,
    val newEpisodes: String?
)

fun ProfileDataList.toComponent(): ProfileRowComponent {
    return ProfileRowComponent(
        this.map {
            it.toComponent()
        }
    )
}

fun ProfileData.toComponent(): ProfileComponent {
    return ProfileComponent(
        name = name.orEmpty(),
        value = value
            ?: "https://play-lh.googleusercontent.com/0fP9JUiv-PKujKpuHXTY-AL8rEFS3uy2c4dAlBUYz8kTVMFktVCKq5dnvlQ42WwL7pQ",
        contentDescription = contentDescription,
        width = width ?: 100,
        height = height ?: 100
    )
}