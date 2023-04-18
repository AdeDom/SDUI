package com.adedom.adaptivecards.data.datasource.adapter

import com.adedom.adaptivecards.data.models.ComponentWeight
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentWeightAdapter {
    @ToJson
    fun toJson(weight: ComponentWeight): String {
        return weight.value
    }

    @FromJson
    fun fromJson(value: String): ComponentWeight? {
        return ComponentWeight.values().firstOrNull { it.value == value }
    }
}