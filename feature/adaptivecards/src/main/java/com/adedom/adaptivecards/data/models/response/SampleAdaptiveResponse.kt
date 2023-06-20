package com.adedom.adaptivecards.data.models.response

import com.adedom.adaptivecards.data.models.Component
import com.squareup.moshi.Json

data class SampleAdaptiveResponse(
    @Json(name = "version") val version: String?,
    @Json(name = "header") val header: List<Component>?,
    @Json(name = "body") val body: List<Component>?,
    @Json(name = "footer") val footer: List<Component>?,
)