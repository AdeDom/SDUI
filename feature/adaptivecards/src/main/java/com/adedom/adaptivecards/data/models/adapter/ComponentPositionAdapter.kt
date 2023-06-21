package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentPosition
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentPositionAdapter {
    @ToJson
    fun toJson(value: ComponentPosition): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentPosition? {
        return ComponentPosition.values().firstOrNull { it.value.lowercase() == value }
    }
}