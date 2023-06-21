package com.adedom.adaptivecards.data.models.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import io.adaptivecards.objectmodel.ImageSize

object ImageSizeAdapter {
    @ToJson
    fun toJson(value: ImageSize): String {
        return value.name
    }

    @FromJson
    fun fromJson(value: String): ImageSize? {
        return ImageSize.values().firstOrNull { it.name.lowercase() == value }
    }
}