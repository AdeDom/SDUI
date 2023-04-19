package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentType
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentTypeAdapter {
    @ToJson
    fun toJson(value: ComponentType): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentType? {
        return ComponentType.values().firstOrNull { it.value == value }
    }
}