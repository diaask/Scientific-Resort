package com.app.data.features

import com.app.data.features.home.mapper.HomeSliderMapper
import com.app.data.features.home.store.HomeRemoteDataStore
import com.app.domain.base.result.AResult
import com.app.domain.base.result.data
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeDataRepository @Inject constructor(
    private val mapper: HomeSliderMapper,
    private val factory: HomeRemoteDataStore
) : HomeRepository {

    override suspend fun getHomeSlider(): Flow<AResult<List<HomeSlider>>> {
        return factory.getHomeSlider().map {
            AResult.success(it.data!!.map { slider ->
                mapper.mapFromEntity(slider)
            })
        }
    }

    override suspend fun getHomeServices(): List<HomeSlider> {
        TODO("Not yet implemented")
    }

    override suspend fun getHomeLongevityFactories(): List<HomeSlider> {
        TODO("Not yet implemented")
    }
}