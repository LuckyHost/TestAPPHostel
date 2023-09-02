package com.example.testapphostel.data

import android.util.*
import com.example.testapphostel.data.NET.*
import com.example.testapphostel.domian.DataClass.*
import com.skydoves.sandwich.*
import javax.inject.*

open class Repository @Inject constructor(
    private val apiService: APIService,
) {

    suspend fun getDataHostel(): Hostels? {
        var result: Hostels? =null
        apiService.getDataHostel()
            .suspendOnSuccess { result = data}
            .suspendOnException {
                Log.d("MyLog", "Repository.kt. getDataHostel: $message")
            }

        return result
    }
}
