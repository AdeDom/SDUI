package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.sample.SampleAdaptiveResponse
import retrofit2.http.GET

interface MockyService {

    @GET("v3/ef51d555-4408-4ba9-9fc5-5bea349b1410")
    suspend fun getAdaptiveCardsDefault(): Component

    @GET("v3/f80b3811-d6a3-45d5-a059-a53b72373c38")
    suspend fun getSampleAdaptive(): SampleAdaptiveResponse
}