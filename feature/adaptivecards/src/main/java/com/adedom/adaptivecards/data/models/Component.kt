package com.adedom.adaptivecards.data.models

import com.adedom.adaptivecards.data.models.enumclass.ComponentAlign
import com.adedom.adaptivecards.data.models.enumclass.ComponentIcon
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentSpacing
import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.adedom.adaptivecards.data.models.enumclass.ComponentWidth
import com.adedom.adaptivecards.data.models.sample.ColumnData
import com.adedom.adaptivecards.data.models.sample.InfoData
import com.adedom.adaptivecards.data.models.sample.MetaData
import com.adedom.adaptivecards.data.models.sample.PageData
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
        @Json(name = "card") val card: Component?,
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
        @Json(name = "index") val index: Int?,
        @Json(name = "items") val items: List<Component> = emptyList(),
        @Json(name = "width") val width: ComponentWidth?,
        @Json(name = "style") val style: ComponentStyle?,
        @Json(name = "selectAction") val selectAction: Component?,
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
        @Json(name = "info") val info: InfoData?,
        @Json(name = "ratio") val ratio: String?,
        @Json(name = "column") val column: ColumnData?,
        @Json(name = "overlays") val overlays: List<Component> = emptyList(),
        @Json(name = "items") val items: List<Component> = emptyList(),
        @Json(name = "images") val images: List<String> = emptyList(),
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
        @Json(name = "index") val index: Int?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "text") val text: String?,
        @Json(name = "isSubtle") val isSubtle: Boolean?,
        @Json(name = "wrap") val wrap: Boolean?,
    ) : Component

    data class Banner(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "info") val info: InfoData?,
        @Json(name = "url") val url: String?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component

    data class Text(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "text") val text: String?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "color") val color: String?,
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "align") val align: ComponentAlign?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "selectAction") val selectAction: Component?,
        @Json(name = "maxLines") val maxLines: Int?,
    ) : Component

    data class Container(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component

    data class Cards(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "background") val background: String?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "column") val column: ColumnData?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "page") val page: PageData?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component

    data class Button(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "icon") val icon: ComponentIcon?,
        @Json(name = "align") val align: ComponentAlign?,
    ) : Component

    data class Badge(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "style") val style: ComponentStyle?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component

    data class ActionOpenMore(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "url") val url: String?,
    ) : Component

    data class TextBadge(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "text") val text: String?,
        @Json(name = "meta") val meta: MetaData?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "color") val color: String?,
        @Json(name = "selectAction") val selectAction: Component?,
    ) : Component

    data class LazyHorizontal(
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "column") val column: ColumnData?,
        @Json(name = "columns") val columns: List<Component> = emptyList(),
    ) : Component
}