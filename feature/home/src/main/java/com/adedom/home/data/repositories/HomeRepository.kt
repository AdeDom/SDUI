package com.adedom.home.data.repositories

import com.adedom.ui_component.data.models.SduiData

interface HomeRepository {

    fun getHome(): SduiData
}