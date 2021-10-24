package com.app.domain.feature.home.repository

import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.Factors
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.model.Service
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHomeSlider(): Flow<AResult<List<HomeSlider>>>
    suspend fun getHomeLongevityFactories(): Flow<AResult<List<Factors>>>
    suspend fun getHomeServices(): Flow<AResult<List<Service>>>
}