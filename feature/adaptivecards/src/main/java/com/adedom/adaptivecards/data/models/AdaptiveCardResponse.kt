package com.adedom.adaptivecards.data.models

import com.squareup.moshi.Json

data class AdaptiveCardResponse(
    @Json(name = "type") val type: String?,
    @Json(name = "body") val body: List<Component> = emptyList(),
    @Json(name = "\$schema") val schema: String?,
    @Json(name = "version") val version: String?,
)

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

enum class ComponentType(val value: String) {
    ACTION_OPEN_URL("Action.OpenUrl"),
    ACTION_SHOW_CARD("Action.ShowCard"),
    ACTION_SUBMIT("Action.Submit"),
    ADAPTIVE_CARD("AdaptiveCard"),
    COLUMN("Column"),
    COLUMN_SET("ColumnSet"),
    FACT_SET("FactSet"),
    IMAGE("Image"),
    INPUT_DATE("Input.Date"),
    INPUT_TEXT("Input.Text"),
    TEXT_BLOCK("TextBlock"),
}

enum class ComponentSize(val value: String) {
    MEDIUM("Medium")
}

enum class ComponentWeight(val value: String) {
    BOLDER("Bolder")
}