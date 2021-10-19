package com.app.domain.feature.home.interactor

import com.app.domain.base.interactor.UseCase
import com.app.domain.base.result.AResult
import com.app.domain.feature.home.model.HomeSlider
import com.app.domain.feature.home.model.Location
import com.app.domain.feature.home.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetOurLocations @Inject constructor(
    private val repository: HomeRepository,
) : UseCase<Flow<AResult<List<Location>>>, Unit>() {

    override fun execute(params: Unit): Flow<AResult<List<Location>>> =
        flow {
            try {
                val data = arrayListOf(
                    Location(
                        1,
                        "Maldives",
                        "Subtitle",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Location(
                        2,
                        " Funadhoo viligilla",
                        "Subtitle",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    ),
                    Location(
                        3,
                        "Gaafu Alif",
                        "Subtitle",
                        "https://www.longevityscientificresort.com/images/resort/img-4.jpg"
                    )
                )
                emit(AResult.Success(data))
//                repository.getLocations()
            } catch (e: Exception) {
                emit(AResult.Error(e))
            }
        }

}