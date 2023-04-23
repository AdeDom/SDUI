package com.adedom.adaptivecards.data.models.datamodel

import com.squareup.moshi.Json

data class InfoData(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
)