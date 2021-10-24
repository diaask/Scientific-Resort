package com.app.data.di

import com.app.data.features.HomeDataRepository
import com.app.domain.feature.home.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindHomeDataRepository(dataRepository: HomeDataRepository): HomeRepository

}