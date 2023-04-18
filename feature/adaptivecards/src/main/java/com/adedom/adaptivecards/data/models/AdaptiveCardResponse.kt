package com.adedom.adaptivecards.data.models

import com.squareup.moshi.Json

data class AdaptiveCardResponse(
    @Json(name = "type") val type: String?,
    @Json(name = "\$schema") val schema: String?,
    @Json(name = "version") val version: String?,
)