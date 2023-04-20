package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ComponentAlign
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ComponentAlignAdapter {
    @ToJson
    fun toJson(value: ComponentAlign): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ComponentAlign? {
        return ComponentAlign.values().firstOrNull { it.value == value }
    }
}