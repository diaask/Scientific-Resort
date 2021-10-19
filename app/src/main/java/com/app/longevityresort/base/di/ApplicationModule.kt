package com.app.longevityresort.base.di

import android.app.Application
import android.content.Context
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.repository.HomeRepository
import com.app.longevityresort.R
import com.app.longevityresort.base.BaseApplication
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module(includes = [CoroutinesModule::class, GlideModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

}

@Module
@InstallIn(SingletonComponent::class)
internal object GlideModule {

    @Provides
    fun provideRequestOptions(): RequestOptions {
        return RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    }

    @Provides
    fun provideGlideInstance(
        application: Application,
        requestOptions: RequestOptions
    ): RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

}
@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindHomeRepository(dataRepository: InterfaceImpl): HomeRepository
}

class InterfaceImpl @Inject constructor() : HomeRepository{
    override suspend fun getHomeSlider(): List<HomeSlider> {
        TODO("Not yet implemented")
    }

    override suspend fun getHomeServices(): List<HomeSlider> {
        TODO("Not yet implemented")
    }

    override suspend fun getHomeLongevityFactories(): List<HomeSlider> {
        TODO("Not yet implemented")
    }

}