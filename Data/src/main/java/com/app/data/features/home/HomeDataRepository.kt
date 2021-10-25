package com.app.data.features.home

import com.app.data.features.home.mapper.FactorMapper
import com.app.data.features.home.mapper.HomeSliderMapper
import com.app.data.features.home.mapper.LocationsMapper
import com.app.data.features.home.mapper.ServiceMapper
import com.app.data.features.home.store.HomeRemoteDataStore
import com.app.domain.base.result.AResult
import com.app.domain.base.result.data
import com.app.domain.feature.home.model.Factors
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.model.Location
import com.app.domain.feature.home.model.Service
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeDataRepository @Inject constructor(
    private val sliderMapper: HomeSliderMapper,
    private val factorMapper: FactorMapper,
    private val serviceMapper: ServiceMapper,
    private val locationsMapper: LocationsMapper,
    private val factory: HomeRemoteDataStore
) : HomeRepository {

    override suspend fun getHomeSlider(): Flow<AResult<List<HomeSlider>>> {
        return factory.getHomeSlider().map {
            AResult.success(it.data!!.map { slider ->
                sliderMapper.mapFromEntity(slider)
            })
        }
    }

    override suspend fun getHomeLongevityFactories(): Flow<AResult<List<Factors>>> {
        return factory.getFactors().map {
            AResult.success(it.data!!.map { factors ->
                factorMapper.mapFromEntity(factors)
            })
        }
    }

    override suspend fun getHomeServices(): Flow<AResult<List<Service>>> {
        return factory.getServices().map {
            AResult.success(it.data!!.map { factors ->
                serviceMapper.mapFromEntity(factors)
            })
        }
    }

    override suspend fun getlocations(): Flow<AResult<List<Location>>> {
        return factory.getLocations().map {
            AResult.success(it.data!!.map { location ->
                locationsMapper.mapFromEntity(location)
            })
        }
    }
}