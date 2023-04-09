package com.adedom.ui_component.domain.models

data class ImageComponent(
    val number: Int?,
    val name: String?,
    val value: String,
    val contentDescription: String?,
    val width: Int?,
    val height: Int,
    val roundedCornerShape: Int,
    val newEpisodes: String?
) : UiComponent