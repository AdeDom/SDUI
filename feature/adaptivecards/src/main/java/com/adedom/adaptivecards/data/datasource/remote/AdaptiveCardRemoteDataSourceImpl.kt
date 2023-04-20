package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.datasource.DataSourceProvider
import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.sample.SampleAdaptiveResponse

class AdaptiveCardRemoteDataSourceImpl(
    private val dataSourceProvider: DataSourceProvider
) : AdaptiveCardRemoteDataSource {

    override suspend fun getAdaptiveCardsDefault(): Component {
        return dataSourceProvider.getMockyService().getAdaptiveCardsDefault()
    }

    override suspend fun getSampleAdaptive(): SampleAdaptiveResponse {
        return dataSourceProvider.getMockyService().getSampleAdaptive()
    }
}