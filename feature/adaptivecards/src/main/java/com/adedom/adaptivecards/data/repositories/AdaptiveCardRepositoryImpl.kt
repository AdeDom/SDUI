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

    override suspend fun getSampleAdaptive(): Component {
        return withContext(ioDispatcher) {
            adaptiveCardRemoteDataSource.getSampleAdaptive()
        }
    }

    override suspend fun getStartedAdaptiveCards(): Component {
        return withContext(ioDispatcher) {
            adaptiveCardRemoteDataSource.getStartedAdaptiveCards()
        }
    }

    override suspend fun getOverlaysAndPositionAdaptiveCards(): Component {
        return withContext(ioDispatcher) {
            adaptiveCardRemoteDataSource.getOverlaysAndPositionAdaptiveCards()
        }
    }

}