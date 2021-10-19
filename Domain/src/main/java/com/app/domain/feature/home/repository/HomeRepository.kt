package com.app.domain.feature.home.repository

import com.app.domain.feature.home.model.HomeSlider

interface HomeRepository {
    suspend fun getHomeSlider(): List<HomeSlider>
    suspend fun getHomeServices(): List<HomeSlider>
    suspend fun getHomeLongevityFactories(): List<HomeSlider>
}