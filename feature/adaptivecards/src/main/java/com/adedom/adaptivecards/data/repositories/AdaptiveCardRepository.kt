package com.adedom.adaptivecards.data.repositories

import com.adedom.adaptivecards.data.models.Component

interface AdaptiveCardRepository {

    suspend fun getAdaptiveCardsDefault(): Component

    suspend fun getSampleAdaptive(): Component

    suspend fun getStartedAdaptiveCards(): Component

    suspend fun getOverlaysAndPositionAdaptiveCards(): Component

}