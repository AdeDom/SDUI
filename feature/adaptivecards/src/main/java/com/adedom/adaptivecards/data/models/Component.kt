package com.adedom.adaptivecards.data.models

import com.adedom.adaptivecards.data.models.datamodel.ColumnData
import com.adedom.adaptivecards.data.models.datamodel.FactSetData
import com.adedom.adaptivecards.data.models.datamodel.InfoData
import com.adedom.adaptivecards.data.models.datamodel.MetaData
import com.adedom.adaptivecards.data.models.datamodel.PageData
import com.adedom.adaptivecards.data.models.enumclass.ComponentAlign
import com.adedom.adaptivecards.data.models.enumclass.ComponentIcon
import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.adedom.adaptivecards.data.models.enumclass.ComponentSpacing
import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle
import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.adedom.adaptivecards.data.models.enumclass.ComponentWidth
import com.squareup.moshi.Json

sealed class Component(
    open val selectAction: Action?
) {

    data class AdaptiveCard(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "body") val body: List<Component> = emptyList(),
        @Json(name = "actions") val actions: List<Component> = emptyList(),
        @Json(name = "\$schema") val schema: String?,
        @Json(name = "version") val version: String?,
    ) : Component(selectAction)

    data class Column(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "items") val items: List<Component> = emptyList(),
        @Json(name = "width") val width: ComponentWidth?,
        @Json(name = "style") val style: ComponentStyle?,
    ) : Component(selectAction)

    data class ColumnSet(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "columns") val columns: List<Component> = emptyList(),
    ) : Component(selectAction)

    data class FactSet(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "facts") val facts: List<FactSetData> = emptyList(),
    ) : Component(selectAction)

    data class Image(
        @Json(name = "selectAction") override val selectAction: Action?,
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
    ) : Component(selectAction)

    data class InputDate(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "id") val id: String?,
    ) : Component(selectAction)

    data class InputText(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "id") val id: String?,
        @Json(name = "placeholder") val placeholder: String?,
        @Json(name = "isMultiline") val isMultiline: Boolean?,
    ) : Component(selectAction)

    data class TextBlock(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "text") val text: String?,
        @Json(name = "isSubtle") val isSubtle: Boolean?,
        @Json(name = "wrap") val wrap: Boolean?,
    ) : Component(selectAction)

    data class Banner(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "info") val info: InfoData?,
        @Json(name = "url") val url: String?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component(selectAction)

    data class Text(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "text") val text: String?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "color") val color: String = "#000000",
        @Json(name = "weight") val weight: ComponentWeight?,
        @Json(name = "align") val align: ComponentAlign?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "maxLines") val maxLines: Int?,
    ) : Component(selectAction)

    data class Container(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component(selectAction)

    data class Cards(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "index") val index: Int?,
        @Json(name = "background") val background: String?,
        @Json(name = "size") val size: ComponentSize?,
        @Json(name = "column") val column: ColumnData?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "page") val page: PageData?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component(selectAction)

    data class Button(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "icon") val icon: ComponentIcon?,
        @Json(name = "align") val align: ComponentAlign?,
    ) : Component(selectAction)

    data class Badge(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "style") val style: ComponentStyle?,
        @Json(name = "items") val items: List<Component> = emptyList(),
    ) : Component(selectAction)

    data class TextBadge(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "text") val text: String?,
        @Json(name = "meta") val meta: MetaData?,
        @Json(name = "spacing") val spacing: ComponentSpacing?,
        @Json(name = "color") val color: String = "#000000",
    ) : Component(selectAction)

    data class LazyColumn(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "body") val body: List<Component>?,
    ) : Component(selectAction)

    data class LazyHorizontal(
        @Json(name = "selectAction") override val selectAction: Action?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "column") val column: ColumnData?,
        @Json(name = "columns") val columns: List<Component> = emptyList(),
    ) : Component(selectAction)
}