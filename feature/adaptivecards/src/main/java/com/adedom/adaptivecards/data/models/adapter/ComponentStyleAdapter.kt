package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentStyle
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentStyleAdapter {
    @ToJson
    fun toJson(value: ComponentStyle): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentStyle? {
        return ComponentStyle.values().firstOrNull { it.value == value }
    }
}