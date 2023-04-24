package com.adedom.adaptivecards.domain.usecase

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.repositories.AdaptiveCardRepository

class PutComponentArgumentUseCase(
    private val adaptiveCardRepository: AdaptiveCardRepository
) {

    fun execute(component: Component) {
        adaptiveCardRepository.putComponentArgument(component)
    }
}