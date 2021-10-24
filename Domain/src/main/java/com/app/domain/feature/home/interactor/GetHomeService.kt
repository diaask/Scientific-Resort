package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.Service
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class GetHomeService @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<Service>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<Service>>> = runBlocking {
        repository.getHomeServices()
    }
}