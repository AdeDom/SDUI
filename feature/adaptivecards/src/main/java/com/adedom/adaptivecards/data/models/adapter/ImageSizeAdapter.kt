package com.adedom.adaptivecards.data.models.adapter

import com.adedom.adaptivecards.data.models.enumclass.ImageSize
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

object ImageSizeAdapter {
    @ToJson
    fun toJson(value: ImageSize): String {
        return value.value
    }

    @FromJson
    fun fromJson(value: String): ImageSize? {
        return ImageSize.values().firstOrNull { it.value == value }
    }
}