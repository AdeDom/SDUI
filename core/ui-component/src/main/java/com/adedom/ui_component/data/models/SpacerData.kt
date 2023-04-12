package com.adedom.ui_component.data.models

import com.adedom.ui_component.domain.models.SpacerComponent

data class SpacerDataMaster(
    val key: String?,
    val data: SpacerData?
)

data class SpacerData(
    val height: Int?,
)

fun SpacerDataMaster.toComponent(): SpacerComponent {
    return SpacerComponent(
        key = key,
        height = data?.height ?: 0
    )
}