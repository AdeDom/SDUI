package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import retrofit2.http.GET

interface MockyService {

    @GET("v3/ef51d555-4408-4ba9-9fc5-5bea349b1410")
    suspend fun getAdaptiveCardsDefault(): Component

    @GET("v3/9f97d651-c2fe-4f01-b822-242388adf0b4")
    suspend fun getSampleAdaptive(): Component

    @GET("v3/0969275c-a7ca-412e-9a52-9b4da3394be9")
    suspend fun getStartedAdaptiveCards(): Component

    @GET("v3/9fdca725-bf05-4afd-b04a-9b6771ecb1c1")
    suspend fun getOverlaysAndPositionAdaptiveCards(): Component
}