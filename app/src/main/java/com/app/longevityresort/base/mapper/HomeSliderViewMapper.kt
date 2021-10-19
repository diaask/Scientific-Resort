package com.app.longevityresort.base.mapper

import com.app.domain.feature.home.model.HomeSlider
import com.app.longevityresort.base.model.HomeSliderView
import javax.inject.Inject

open class HomeSliderViewMapper @Inject constructor() : Mapper<HomeSliderView, HomeSlider> {

    override fun mapToView(type: HomeSlider): HomeSliderView {
        return HomeSliderView(
            id = type.id,
            title = type.title,
            subtitle = type.subtitle,
            description = type.description,
            url = type.url,
        )
    }

}