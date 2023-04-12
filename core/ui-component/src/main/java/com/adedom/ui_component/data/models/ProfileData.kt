package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.ProfileComponent
import com.adedom.ui_component.domain.models.ProfileRowComponent

data class ProfileDataMaster(
    val key: String?,
    val data: ProfileData?
)

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

class ProfileDataMasterList : ArrayList<ProfileDataMaster>()

fun ProfileDataMasterList.toComponent(): ProfileRowComponent {
    return ProfileRowComponent(
        this.map {
            it.toComponent()
        }
    )
}

fun ProfileDataMaster.toComponent(): ProfileComponent {
    return ProfileComponent(
        key = key,
        name = data?.name.orEmpty(),
        value = data?.value
            ?: "https://play-lh.googleusercontent.com/0fP9JUiv-PKujKpuHXTY-AL8rEFS3uy2c4dAlBUYz8kTVMFktVCKq5dnvlQ42WwL7pQ",
        contentDescription = data?.contentDescription,
        width = data?.width ?: 100,
        height = data?.height ?: 100
    )
}