package com.app.data.di

import android.app.Application
import com.app.remote.features.home.service.HomeService
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideHomeService(firebaseDatabase: FirebaseDatabase): HomeService =
        HomeService(firebaseDatabase)

}

@Module
@InstallIn(SingletonComponent::class)
internal object FirebaseModule {

    @Provides
    fun provideFirebase(application: Application): FirebaseDatabase {
        FirebaseApp.initializeApp(application);
        return FirebaseDatabase.getInstance()
    }
}