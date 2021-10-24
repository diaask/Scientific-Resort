package com.app.longevityresort.features.home

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.domain.base.result.data
import com.app.domain.feature.home.interactor.GetHomeService
import com.app.domain.feature.home.interactor.GetHomeSlider
import com.app.domain.feature.home.interactor.GetLongevityFactors
import com.app.domain.feature.home.interactor.GetOurLocations
import com.app.longevityresort.base.mapper.FactorViewMapper
import com.app.longevityresort.base.mapper.HomeSliderViewMapper
import com.app.longevityresort.base.mapper.LocationViewMapper
import com.app.longevityresort.base.mapper.ServiceViewMapper
import com.app.longevityresort.base.model.FactorsView
import com.app.longevityresort.base.model.HomeSliderView
import com.app.longevityresort.base.model.LocationView
import com.app.longevityresort.base.model.ServiceView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeSlider: GetHomeSlider,
    private val homeSliderViewMapper: HomeSliderViewMapper,
    private val getLongevityFactors: GetLongevityFactors,
    private val factorViewMapper: FactorViewMapper,
    private val getHomeService: GetHomeService,
    private val serviceViewMapper: ServiceViewMapper,
    private val getOurLocations: GetOurLocations,
    private val locationViewMapper: LocationViewMapper
) : ViewModel() {

    val loading = mutableStateOf(false)

    val homeSlider: MutableState<List<HomeSliderView>> = mutableStateOf(ArrayList())
    val longevityFactors: MutableState<List<FactorsView>> = mutableStateOf(ArrayList())
    val services: MutableState<List<ServiceView>> = mutableStateOf(ArrayList())
    val locations: MutableState<List<LocationView>> = mutableStateOf(ArrayList())

    init {
        homeSlider()
        getLongevityFactors()
        getServices()
        getLocaions()
    }

    private fun homeSlider() {
        viewModelScope.launch {
            try {
                loading.value = true
                getHomeSlider(Unit)
                    .onStart { loading.value = true }
                    .onCompletion { loading.value = false }
                    .catch { error ->
                        Log.e("Error", error.stackTrace.toString())
                    }.collect {
                        it.data?.let { apiList ->
                            homeSlider.value = apiList.map { homeSliderViewMapper.mapToView(it) }
                        }
                    }
                loading.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
            }
        }
    }

    private fun getLongevityFactors() {
        viewModelScope.launch {
            try {
                loading.value = true
                getLongevityFactors(Unit)
                    .onStart { loading.value = true }
                    .onCompletion { loading.value = false }
                    .catch {}.collect {
                        it.data?.let { apiList ->
                            longevityFactors.value = apiList.map { factorViewMapper.mapToView(it) }
                        }
                    }
                loading.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
            }
        }
    }

    private fun getServices() {
        viewModelScope.launch {
            try {
                loading.value = true
                getHomeService(Unit)
                    .onStart { loading.value = true }
                    .onCompletion { loading.value = false }
                    .catch {}.collect {
                        it.data?.let { apiList ->
                            services.value = apiList.map { serviceViewMapper.mapToView(it) }
                        }
                    }
                loading.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
            }
        }
    }

    private fun getLocaions() {
        viewModelScope.launch {
            try {
                loading.value = true
                getOurLocations(Unit)
                    .onStart { loading.value = true }
                    .onCompletion { loading.value = false }
                    .catch {}.collect {
                        it.data?.let { apiList ->
                            locations.value = apiList.map { locationViewMapper.mapToView(it) }
                        }
                    }
                loading.value = false
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
            }
        }
    }

}