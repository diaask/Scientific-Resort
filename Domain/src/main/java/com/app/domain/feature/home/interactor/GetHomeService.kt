package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.Service
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeService @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<Service>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<Service>>> =
        flow {
            try {
                val data = arrayListOf(
                    Service(1, "30 days + stay in an over-water villa"),
                    Service(2, "Access only to designated customers"),
                    Service(3, "Fitness & spa. Standard resort activities"),
                    Service(4, "Longevity clinical trials for selected clients"),
                    Service(5, "Tracking 30 days before stay & lifetime after stay"),
                    Service(6, "Longevity treatments conducted by leading scientists Longevity treatments conducted by leading scientists"),
                    Service(7, "Nutrition plan designed by leading longevity scientists")
                )
                emit(AResult.Success(data))
//                repository.get_root_ide_package_.com.app.domain.feature.home.model.Service()
            } catch (e: Exception) {
                emit(AResult.Error(e))
            }
        }

}