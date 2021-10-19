package com.app.longevityresort.features.locations

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.domain.base.result.data
import com.app.domain.feature.home.interactor.GetOurLocations
import com.app.longevityresort.base.mapper.LocationViewMapper
import com.app.longevityresort.base.model.LocationView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val getOurLocations: GetOurLocations,
    private val locationViewMapper: LocationViewMapper
) : ViewModel() {

    val loading = mutableStateOf(false)

    val locations: MutableState<List<LocationView>> = mutableStateOf(ArrayList())

    init {
        getLocations()
    }

    private fun getLocations() {
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