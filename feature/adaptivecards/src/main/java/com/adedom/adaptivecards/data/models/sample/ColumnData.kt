package com.adedom.adaptivecards.data.models.sample

import com.squareup.moshi.Json

data class ColumnData(
    @Json(name = "phone") val phone: Float?,
    @Json(name = "tablet") val tablet: Float?,
)