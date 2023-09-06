package com.example.testapphostel.data.NET

import com.example.testapphostel.domian.DataClass.*
import com.skydoves.sandwich.*
import retrofit2.http.GET

interface APIService {

    @GET("v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getDataHostel():ApiResponse<Hostels>

    @GET("v3/f9a38183-6f95-43aa-853a-9c83cbb05ecd")
    suspend fun getDataRoom():ApiResponse<InfoRoom>

    @GET("v3/e8868481-743f-4eb2-a0d7-2bc4012275c8")
    suspend fun getDataRezerv():ApiResponse<Rezerv>
}