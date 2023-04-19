package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.datasource.DataSourceProvider
import com.adedom.adaptivecards.data.models.Component

class AdaptiveCardRemoteDataSourceImpl(
    private val dataSourceProvider: DataSourceProvider
) : AdaptiveCardRemoteDataSource {

    override suspend fun getAdaptiveCard(): Component {
        return dataSourceProvider.getMockyService().getMock()
    }
}