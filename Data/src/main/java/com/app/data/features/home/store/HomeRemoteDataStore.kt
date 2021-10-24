package com.app.data.features.home.store

import com.app.data.features.home.model.HomeSliderEntity
import com.app.data.features.home.repository.HomeRemote
import com.app.domain.base.executor.IoDispatcher
import com.app.domain.base.result.AResult
import com.app.domain.base.result.data
import com.app.remote.features.home.mapper.HomeSliderModelMapper
import com.app.remote.features.home.service.HomeService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class HomeRemoteDataStore @Inject constructor(
    private val service: HomeService,
    private val mapper: HomeSliderModelMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HomeRemote {

    override suspend fun getHomeSlider(): Flow<AResult<List<HomeSliderEntity>>> {
        return service.getHomeSlider().map {
            AResult.success(it.data!!.map { slider -> mapper.mapFromModel(slider) })
        }

    }

}