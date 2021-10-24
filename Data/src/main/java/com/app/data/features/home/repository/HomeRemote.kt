package com.app.data.features.home.repository

import com.app.data.features.home.model.HomeSliderEntity
import com.app.domain.base.result.AResult
import kotlinx.coroutines.flow.Flow

interface HomeRemote {
    suspend fun getHomeSlider(): Flow<AResult<List<HomeSliderEntity>>>
}