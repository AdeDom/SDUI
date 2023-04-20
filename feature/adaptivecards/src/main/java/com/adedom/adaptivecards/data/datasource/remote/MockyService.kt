package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.sample.SampleAdaptiveResponse
import retrofit2.http.GET

interface MockyService {

    @GET("v3/ef51d555-4408-4ba9-9fc5-5bea349b1410")
    suspend fun getAdaptiveCardsDefault(): Component

    @GET("v3/42123460-2016-48bb-8bef-e7a09fcedada")
    suspend fun getSampleAdaptive(): SampleAdaptiveResponse
}