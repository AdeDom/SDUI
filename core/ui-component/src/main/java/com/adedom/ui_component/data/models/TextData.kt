package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.TextComponent
import com.google.gson.annotations.SerializedName

data class TextDataMaster(
    val key: String?,
    val data: TextData?
)

data class TextData(
    val value: String?,
    val color: String?,
    val fontSize: Int?,
    val fontWeight: Int?,
    @SerializedName("padding") val padding: PaddingData?
)

fun TextDataMaster.toComponent(): TextComponent {
    return TextComponent(
        key = key,
        value = data?.value.orEmpty(),
        color = data?.color ?: "000000",
        fontSize = data?.fontSize ?: 16,
        fontWeight = data?.fontWeight ?: 400,
        padding = data?.padding ?: PaddingData()
    )
}