package com.adedom.ui_component.utils

import com.adedom.ui_component.data.models.*
import com.adedom.ui_component.domain.models.NoneComponent
import com.google.gson.Gson
import com.google.gson.JsonDeserializer

object SduiUtils {

    private const val components = "components"

    private const val type = "type"
    private const val imageRowComponentType = "ImageRowComponent"
    private const val profileRowComponentType = "ProfileRowComponent"
    private const val textComponentType = "TextComponent"
    private const val imageComponentType = "ImageComponent"
    private const val profileComponentType = "ProfileComponent"
    private const val spacerComponentType = "SpacerComponent"

    private const val children = "children"

    fun jsonDeserializer(): JsonDeserializer<SduiData> {
        return JsonDeserializer<SduiData> { json, _, _ ->
            val jsonArray = json.asJsonObject[components].asJsonArray
            val components = jsonArray.map { jsonElement ->
                try {
                    val component = jsonElement.asJsonObject
                    when (component[type].asString) {
                        imageRowComponentType -> {
                            val jsonString = component[children].toString()
                            Gson().fromJson(jsonString, ImageDataMasterList::class.java)
                                .toComponent()
                        }
                        profileRowComponentType -> {
                            val jsonString = component[children].toString()
                            Gson().fromJson(jsonString, ProfileDataMasterList::class.java)
                                .toComponent()
                        }
                        textComponentType -> {
                            val jsonString = component.toString()
                            Gson().fromJson(jsonString, TextDataMaster::class.java).toComponent()
                        }
                        imageComponentType -> {
                            val jsonString = component.toString()
                            Gson().fromJson(jsonString, ImageDataMaster::class.java).toComponent()
                        }
                        profileComponentType -> {
                            val jsonString = component.toString()
                            Gson().fromJson(jsonString, ProfileDataMaster::class.java).toComponent()
                        }
                        spacerComponentType -> {
                            val jsonString = component.toString()
                            Gson().fromJson(jsonString, SpacerDataMaster::class.java).toComponent()
                        }
                        else -> NoneComponent
                    }
                } catch (e: Throwable) {
                    NoneComponent
                }
            }

            SduiData(components)
        }
    }
}