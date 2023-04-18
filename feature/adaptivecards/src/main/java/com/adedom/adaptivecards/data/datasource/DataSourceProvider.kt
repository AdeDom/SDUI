package com.adedom.adaptivecards.data.datasource

import com.adedom.adaptivecards.data.datasource.remote.MockyService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class DataSourceProvider {

    fun getMockyService(): MockyService {
        val moshi: Moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://run.mocky.io/")
            .build()
            .create()
    }
}