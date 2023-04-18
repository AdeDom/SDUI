package com.adedom.adaptivecards.data.datasource.adapter

import com.adedom.adaptivecards.data.models.ComponentSize
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentSizeAdapter {
    @ToJson
    fun toJson(size: ComponentSize): String {
        return size.value
    }

    @FromJson
    fun fromJson(value: String): ComponentSize? {
        return ComponentSize.values().firstOrNull { it.value == value }
    }
}