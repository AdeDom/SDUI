package com.adedom.home.data.repositories

import android.content.Context
import com.adedom.ui_component.data.models.SduiData
import com.adedom.ui_component.utils.SduiUtils
import com.google.gson.GsonBuilder

class HomeRepositoryImpl(
    private val context: Context
) : HomeRepository {

    override fun getHome(): SduiData {
        val jsonString = context.assets.open("home.json").bufferedReader().use {
            it.readText()
        }
        return GsonBuilder()
            .registerTypeAdapter(SduiData::class.java, SduiUtils.jsonDeserializer())
            .create()
            .fromJson(jsonString, SduiData::class.java)
    }
}