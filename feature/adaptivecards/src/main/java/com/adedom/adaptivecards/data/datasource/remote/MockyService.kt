package com.adedom.adaptivecards.data.datasource.remote

import com.adedom.adaptivecards.data.models.Component
import retrofit2.http.GET

interface MockyService {

    @GET("v3/ef51d555-4408-4ba9-9fc5-5bea349b1410")
    suspend fun getMock(): Component
}