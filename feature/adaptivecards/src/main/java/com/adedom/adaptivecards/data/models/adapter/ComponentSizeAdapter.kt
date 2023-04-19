package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentSize
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentSizeAdapter {
    @ToJson
    fun toJson(value: ComponentSize): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentSize? {
        return ComponentSize.values().firstOrNull { it.value == value }
    }
}