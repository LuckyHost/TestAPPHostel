package com.example.testapphostel.data.DI

import com.example.testapphostel.data.*
import com.example.testapphostel.data.NET.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleRepository {




    @Singleton
    @Provides
    fun provideRepository(apiService: APIService):Repository{
        return Repository(apiService)
    }
}