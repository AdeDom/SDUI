package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.AdaptiveCardResponse

interface AdaptiveCardRemoteDataSource {

    suspend fun getAdaptiveCard(): AdaptiveCardResponse
}