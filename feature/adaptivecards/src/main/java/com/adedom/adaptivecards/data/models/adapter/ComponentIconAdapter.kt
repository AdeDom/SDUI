package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentIcon
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentIconAdapter {
    @ToJson
    fun toJson(value: ComponentIcon): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentIcon? {
        return ComponentIcon.values().firstOrNull { it.value == value }
    }
}