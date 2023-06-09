package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.datasource.DataSourceProvider
import com.adedom.adaptivecards.data.models.Component

class AdaptiveCardRemoteDataSourceImpl(
    private val dataSourceProvider: DataSourceProvider
) : AdaptiveCardRemoteDataSource {

    override suspend fun getAdaptiveCardsDefault(): Component {
        return dataSourceProvider.getMockyService().getAdaptiveCardsDefault()
    }

    override suspend fun getSampleAdaptive(): Component {
        return dataSourceProvider.getMockyService().getSampleAdaptive()
    }

    override suspend fun getStartedAdaptiveCards(): Component {
        return dataSourceProvider.getMockyService().getStartedAdaptiveCards()
    }

    override suspend fun getOverlaysAndPositionAdaptiveCards(): Component {
        return dataSourceProvider.getMockyService().getOverlaysAndPositionAdaptiveCards()
    }
}