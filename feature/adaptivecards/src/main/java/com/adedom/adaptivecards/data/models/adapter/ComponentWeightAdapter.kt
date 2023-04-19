package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentWeight
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentWeightAdapter {
    @ToJson
    fun toJson(value: ComponentWeight): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentWeight? {
        return ComponentWeight.values().firstOrNull { it.value == value }
    }
}