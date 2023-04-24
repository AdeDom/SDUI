package com.adedom.adaptivecards.domain.usecase

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepository

class GetComponentArgumentUseCase(
    private val adaptiveCardRepository: AdaptiveCardRepository
) {

    fun execute(): Component? {
        return adaptiveCardRepository.getComponentArgument()
    }
}