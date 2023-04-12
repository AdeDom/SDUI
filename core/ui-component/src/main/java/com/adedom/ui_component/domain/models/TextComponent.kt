package com.adedom.ui_component.domain.models

import com.adedom.ui_component.data.models.PaddingData

data class TextComponent(
    val key: String?,
    val value: String,
    val color: String,
    val fontSize: Int,
    val fontWeight: Int,
    val padding: PaddingData
) : UiComponent