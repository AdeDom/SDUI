package com.adedom.ui_component.domain.models

import com.adedom.ui_component.data.models.PaddingData

sealed interface UiComponent

data class ImageRowComponent(
    val imageComponents: List<ImageComponent>
) : UiComponent

data class ProfileRowComponent(
    val profileComponents: List<ProfileComponent>
) : UiComponent

data class TextComponent(
    val key: String?,
    val value: String,
    val color: String,
    val fontSize: Int,
    val fontWeight: Int,
    val padding: PaddingData
) : UiComponent

data class ImageComponent(
    val key: String?,
    val number: Int?,
    val name: String?,
    val value: String,
    val contentDescription: String?,
    val width: Int?,
    val height: Int,
    val roundedCornerShape: Int,
    val newEpisodes: String?
) : UiComponent

data class ProfileComponent(
    val key: String?,
    val name: String,
    val value: String,
    val contentDescription: String?,
    val width: Int,
    val height: Int
) : UiComponent

data class SpacerComponent(
    val key: String?,
    val height: Int
) : UiComponent

object NoneComponent : UiComponent
