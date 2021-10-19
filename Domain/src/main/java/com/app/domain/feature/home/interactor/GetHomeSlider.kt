package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetHomeSlider @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<HomeSlider>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<HomeSlider>>> =
        flow {
            try {
                val data = arrayListOf(
                    HomeSlider(
                        1,
                        "LONGEVITY SCIENTIFIC RESORT",
                        "Live Smart, Live Longer",
                        "Description",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    HomeSlider(
                        2,
                        "LONGEVITY SCIENTIFIC RESORT",
                        "Live Smart, Live Longer",
                        "Description",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    HomeSlider(
                        3,
                        "LONGEVITY SCIENTIFIC RESORT",
                        "Live Smart, Live Longer",
                        "Description",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    HomeSlider(
                        4,
                        "LONGEVITY SCIENTIFIC RESORT",
                        "Live Smart, Live Longer",
                        "Description",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    HomeSlider(
                        5,
                        "LONGEVITY SCIENTIFIC RESORT",
                        "Live Smart, Live Longer",
                        "Description",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                )
                emit(AResult.Success(data))
//                repository.getHomeSlider()
            } catch (e: Exception) {
                emit(AResult.Error(e))
            }
        }

}