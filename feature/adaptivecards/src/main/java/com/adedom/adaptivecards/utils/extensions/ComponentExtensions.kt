package com.adedom.adaptivecards.utils.extensions

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.utils.moshi.MoshiUtil

fun Component.toJson(): String {
    return MoshiUtil.getMoshi().adapter(Component::class.java).toJson(this)
}

fun String.fromJson(): Component? {
    return MoshiUtil.getMoshi().adapter(Component::class.java).fromJson(this)
}