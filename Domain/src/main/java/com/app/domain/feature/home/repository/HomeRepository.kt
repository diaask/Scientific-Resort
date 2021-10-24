package com.app.domain.feature.home.repository

import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.HomeSlider
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getHomeSlider(): Flow<AResult<List<HomeSlider>>>
    suspend fun getHomeServices(): List<HomeSlider>
    suspend fun getHomeLongevityFactories(): List<HomeSlider>
}