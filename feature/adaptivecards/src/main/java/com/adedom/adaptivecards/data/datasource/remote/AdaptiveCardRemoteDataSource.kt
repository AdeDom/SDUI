package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.sample.SampleAdaptiveResponse

interface AdaptiveCardRemoteDataSource {

    suspend fun getAdaptiveCardsDefault(): Component

    suspend fun getSampleAdaptive(): SampleAdaptiveResponse
}