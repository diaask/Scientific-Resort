package com.app.remote.features.home.mapper

import com.app.data.features.home.model.HomeSliderEntity
import com.app.remote.base.ModelMapper
import com.app.remote.features.home.model.HomeSliderModel
import javax.inject.Inject

class HomeSliderModelMapper @Inject constructor() : ModelMapper<HomeSliderModel, HomeSliderEntity> {

    override fun mapFromModel(model: HomeSliderModel) = HomeSliderEntity(
        id = model.id,
        title = model.title,
        subtitle = model.subtitle,
        description = model.description,
        url = model.url,
    )
}