package com.example.testapphostel.data.NET

import com.example.testapphostel.domian.DataClass.*
import com.skydoves.sandwich.*
import retrofit2.http.GET

interface APIService {

    @GET("v3/35e0d18e-2521-4f1b-a575-f0fe366f66e3")
    suspend fun getDataHostel():ApiResponse<Hostels>
}