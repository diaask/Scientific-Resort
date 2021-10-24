package com.app.data.features.home.store

import com.app.data.features.home.model.FactorsEntity
import com.app.data.features.home.model.HomeSliderEntity
import com.app.data.features.home.model.LocationEntity
import com.app.data.features.home.model.ServiceEntity
import com.app.data.features.home.repository.HomeRemote
import com.app.domain.base.executor.IoDispatcher
import com.app.domain.base.result.AResult
import com.app.domain.base.result.data
import com.app.remote.features.home.mapper.FactorModelMapper
import com.app.remote.features.home.mapper.HomeSliderModelMapper
import com.app.remote.features.home.mapper.ServiceModelMapper
import com.app.remote.features.home.mapper.locationsModelMapper
import com.app.remote.features.home.service.HomeService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class HomeRemoteDataStore @Inject constructor(
    private val service: HomeService,
    private val sliderMapper: HomeSliderModelMapper,
    private val factorMapper: FactorModelMapper,
    private val serviceMapper: ServiceModelMapper,
    private val locationsMapper: locationsModelMapper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HomeRemote {

    override suspend fun getHomeSlider(): Flow<AResult<List<HomeSliderEntity>>> {
        return service.getHomeSlider().map {
            AResult.success(it.data!!.map { slider -> sliderMapper.mapFromModel(slider) })
        }
    }

    override suspend fun getFactors(): Flow<AResult<List<FactorsEntity>>> {
        return service.getHomeFactors().map {
            AResult.success(it.data!!.map { factor -> factorMapper.mapFromModel(factor) })
        }
    }

    override suspend fun getServices(): Flow<AResult<List<ServiceEntity>>> {
        return service.getHomeService().map {
            AResult.success(it.data!!.map { service -> serviceMapper.mapFromModel(service) })
        }
    }

    override suspend fun getLocations(): Flow<AResult<List<LocationEntity>>> {
        return service.getLocations().map {
            AResult.success(it.data!!.map { location -> locationsMapper.mapFromModel(location) })
        }
    }

}