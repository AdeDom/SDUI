package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import com.adedom.adaptivecards.data.models.sample.SampleAdaptiveResponse
import retrofit2.http.GET

interface MockyService {

    @GET("v3/ef51d555-4408-4ba9-9fc5-5bea349b1410")
    suspend fun getAdaptiveCardsDefault(): Component

    @GET("v3/30b70f78-1d93-4885-8734-a4ddc8169bcc")
    suspend fun getSampleAdaptive(): SampleAdaptiveResponse
}