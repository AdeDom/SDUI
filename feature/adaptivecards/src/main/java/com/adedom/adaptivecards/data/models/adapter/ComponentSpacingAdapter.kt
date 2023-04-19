package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentSpacing
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentSpacingAdapter {
    @ToJson
    fun toJson(value: ComponentSpacing): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentSpacing? {
        return ComponentSpacing.values().firstOrNull { it.value == value }
    }
}