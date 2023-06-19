package com.adedom.adaptivecards.data.models

import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.squareup.moshi.Json

sealed interface Action {

    val id: Int?

    data class OpenUrl(
        @Json(name = "id") override val id: Int?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "url") val url: String?,
    ) : Action

    data class ShowCard(
        @Json(name = "id") override val id: Int?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "card") val card: Component?,
    ) : Action

    data class Submit(
        @Json(name = "id") override val id: Int?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
    ) : Action

    data class OpenMore(
        @Json(name = "id") override val id: Int?,
        @Json(name = "type") val type: ComponentType?,
        @Json(name = "title") val title: String?,
        @Json(name = "url") val url: String?,
    ) : Action
}