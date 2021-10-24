package com.app.data.di

import com.app.data.features.home.repository.HomeRemote
import com.app.data.features.home.store.HomeRemoteDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {

    @Binds
    abstract fun bindHomeRemote(remoteImpl: HomeRemoteDataStore): HomeRemote
}