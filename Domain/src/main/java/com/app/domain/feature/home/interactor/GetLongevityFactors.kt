package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.Factors
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLongevityFactors @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<Factors>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<Factors>>> =
        flow {
            try {
                val data = arrayListOf(
                    Factors(
                        1,
                        "Mild Climate",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Factors(
                        2,
                        "Social Connections",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Factors(
                        3,
                        "Fitness & Wellness Activity",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Factors(
                        4,
                        "Social Recognition",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Factors(
                        5,
                        "Work",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Factors(
                        6,
                        "Balanced Nutrition's",
                        "Lorem Ipsum is simply dummy text of the printing and type setting",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    )
                )
                emit(AResult.Success(data))// Api call simulation
//                repository.getHomeLongevityFactories()
            } catch (e: Exception) {
                emit(AResult.Error(e))
            }
        }

}