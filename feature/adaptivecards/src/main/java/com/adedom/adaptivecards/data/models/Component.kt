package com.adedom.adaptivecards.data.models

import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentSpacing
import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.adedom.adaptivecards.data.models.enumclass.ComponentWidth
import com.squareup.moshi.Json

sealed interface Component {

    data class ActionOpenUrl(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "url") val url: String?,
    ) : Component

    data class ActionShowCard(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "card") val card: AdaptiveCard?,
    ) : Component

    data class ActionSubmit(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
    ) : Component

    data class AdaptiveCard(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "body") val body: List<Component> = emptyList(),
        @Json(name = "actions") val actions: List<Component> = emptyList(),
        @Json(name = "\$schema") val schema: String?,
        @Json(name = "version") val version: String?,
    ) : Component

    data class Column(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "items") val items: List<Component> = emptyList(),
        @Json(name = "width") val width: ComponentWidth?,
    ) : Component

    data class ColumnSet(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "columns") val columns: List<Component> = emptyList(),
    ) : Component

    data class FactSet(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "facts") val facts: List<FactSetData> = emptyList(),
    ) : Component

    data class Image(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "style") val style: ComponentStyle?,
        @Json(name = "url") val url: String?,
        @Json(name = "size") val size: ComponentSize?,
    ) : Component

    data class InputDate(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "id") val id: String?,
    ) : Component

    data class InputText(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "id") val id: String?,
        @Json(name = "placeholder") val placeholder: String?,
        @Json(name = "isMultiline") val isMultiline: Boolean?,
    ) : Component

    data class TextBlock(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "text") val text: String?,
        @Json(name = "isSubtle") val isSubtle: Boolean?,
        @Json(name = "wrap") val wrap: Boolean?,
    ) : Component
}