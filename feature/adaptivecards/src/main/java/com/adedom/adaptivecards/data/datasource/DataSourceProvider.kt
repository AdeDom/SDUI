package com.adedom.adaptivecards.data.datasource

import com.adedom.adaptivecards.data.datasource.remote.MockyService
import com.adedom.adaptivecards.utils.moshi.MoshiUtil
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class DataSourceProvider {

    fun getMockyService(): MockyService {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(MoshiUtil.getMoshi()))
            .baseUrl("https://run.mocky.io/")
            .build()
            .create()
    }
}