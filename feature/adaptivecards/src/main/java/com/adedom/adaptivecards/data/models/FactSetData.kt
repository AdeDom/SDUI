package com.adedom.adaptivecards.data.models

import com.squareup.moshi.Json

data class FactSetData(
    @Json(name = "\$data") val data: String?,
    @Json(name = "title") val title: String?,
    @Json(name = "value") val value: String?,
)