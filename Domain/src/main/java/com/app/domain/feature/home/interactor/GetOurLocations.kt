package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.Location
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class GetOurLocations @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<Location>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<Location>>> = runBlocking {
        repository.getlocations()
    }
}