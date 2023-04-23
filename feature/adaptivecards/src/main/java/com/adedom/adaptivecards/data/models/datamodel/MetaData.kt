package com.adedom.adaptivecards.data.models.datamodel

import com.squareup.moshi.Json

data class MetaData(
    @Json(name = "start") val start: String?,
    @Json(name = "expired") val expired: String?,
)