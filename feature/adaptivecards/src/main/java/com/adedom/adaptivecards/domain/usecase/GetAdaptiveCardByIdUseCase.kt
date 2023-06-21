package com.adedom.adaptivecards.domain.usecase

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepository

class GetAdaptiveCardByIdUseCase(
    private val adaptiveCardRepository: AdaptiveCardRepository
) {

    suspend fun execute(id: Int?): Component {
        return when (id) {
            1 -> adaptiveCardRepository.getStartedAdaptiveCards()
            2 -> adaptiveCardRepository.getOverlaysAndPositionAdaptiveCards()
            else -> adaptiveCardRepository.getSampleAdaptive()
        }
    }

}