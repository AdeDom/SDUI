package com.adedom.adaptivecards.data.repositories

import com.adedom.adaptivecards.data.datasource.remote.AdaptiveCardRemoteDataSource
import com.adedom.adaptivecards.data.models.Component
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AdaptiveCardRepositoryImpl(
    private val adaptiveCardRemoteDataSource: AdaptiveCardRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher
) : AdaptiveCardRepository {

    override suspend fun getAdaptiveCardsDefault(): Component {
        return withContext(ioDispatcher) {
            adaptiveCardRemoteDataSource.getAdaptiveCardsDefault()
        }
    }

    override suspend fun getSampleAdaptive(): List<Component> {
        return withContext(ioDispatcher) {
            adaptiveCardRemoteDataSource.getSampleAdaptive().body ?: emptyList()
        }
    }
}