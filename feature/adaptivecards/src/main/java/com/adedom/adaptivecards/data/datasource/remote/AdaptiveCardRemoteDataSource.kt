package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component

interface AdaptiveCardRemoteDataSource {

    suspend fun getAdaptiveCard(): Component
}