package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.SpacerComponent

data class SpacerData(
    val height: Int?,
)

fun SpacerData.toComponent(): SpacerComponent {
    return SpacerComponent(
        height = height ?: 0
    )
}