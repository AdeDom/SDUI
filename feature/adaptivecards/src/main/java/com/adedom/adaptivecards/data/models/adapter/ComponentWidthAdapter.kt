package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentWidth
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentWidthAdapter {
    @ToJson
    fun toJson(value: ComponentWidth): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentWidth? {
        return ComponentWidth.values().firstOrNull { it.value == value }
    }
}