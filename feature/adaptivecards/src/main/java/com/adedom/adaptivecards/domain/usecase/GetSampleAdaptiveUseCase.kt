package com.adedom.adaptivecards.domain.usecase

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepository

class GetSampleAdaptiveUseCase(
    private val adaptiveCardRepository: AdaptiveCardRepository
) {

    suspend fun execute(id: Int?): List<Component> {
        return adaptiveCardRepository.getSampleAdaptive(id)
    }
}