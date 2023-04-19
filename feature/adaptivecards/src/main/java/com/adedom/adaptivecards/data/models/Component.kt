package com.adedom.adaptivecards.data.models

import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.squareup.moshi.Json

sealed interface Component {

//    data class Column(
//        @Json(name = "type") val type: ComponentType?,
//        @Json(name = "facts") val facts: List<String> = emptyList(),
//        @Json(name = "width") val width: String?,
//    ) : Component

    data class ColumnSet(
        @Json(name = "type") val type: ComponentType?,
//        @Json(name = "columns") val columns: List<String> = emptyList(),
    ) : Component

    data class FactSet(
        @Json(name = "type") val type: ComponentType?,
//        @Json(name = "facts") val facts: List<String> = emptyList(),
    ) : Component

    data class TextBlock(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "text") val text: String?,
        @Json(name = "wrap") val wrap: Boolean?,
    ) : Component
}