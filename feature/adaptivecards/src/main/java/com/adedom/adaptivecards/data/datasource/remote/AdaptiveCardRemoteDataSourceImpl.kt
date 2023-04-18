package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.datasource.DataSourceProvider
import com.adedom.adaptivecards.data.models.AdaptiveCardResponse

class AdaptiveCardRemoteDataSourceImpl(
    private val dataSourceProvider: DataSourceProvider
) : AdaptiveCardRemoteDataSource {

    override suspend fun getAdaptiveCard(): AdaptiveCardResponse {
        return dataSourceProvider.getMockyService().getMock()
    }
}