package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.TextComponent
import com.google.gson.annotations.SerializedName

data class TextData(
    val value: String?,
    val color: String?,
    val fontSize: Int?,
    val fontWeight: Int?,
    @SerializedName("padding") val padding: PaddingData?
)

fun TextData.toComponent(): TextComponent {
    return TextComponent(
        value = value.orEmpty(),
        color = color ?: "000000",
        fontSize = fontSize ?: 16,
        fontWeight = fontWeight ?: 400,
        padding = padding ?: PaddingData()
    )
}