package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component

interface AdaptiveCardRemoteDataSource {

    suspend fun getAdaptiveCardsDefault(): Component

    suspend fun getSampleAdaptive(): Component

    suspend fun getStartedAdaptiveCards(): Component
}