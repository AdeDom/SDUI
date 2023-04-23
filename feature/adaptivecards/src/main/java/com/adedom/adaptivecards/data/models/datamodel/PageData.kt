package com.adedom.adaptivecards.data.models.datamodel

import com.squareup.moshi.Json

data class PageData(
    @Json(name = "index") val index: Int?,
    @Json(name = "total") val total: Int?,
    @Json(name = "totalRecords") val totalRecords: Int?,
)