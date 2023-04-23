package com.adedom.adaptivecards.data.repositories

import com.adedom.adaptivecards.data.models.Component

interface AdaptiveCardRepository {

    suspend fun getAdaptiveCardsDefault(): Component

    suspend fun getSampleAdaptive(): List<Component>
}