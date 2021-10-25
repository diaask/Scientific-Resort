package com.app.data.features.home.mapper

import com.app.data.base.EntityMapper
import com.app.data.features.home.model.HomeSliderEntity
import com.app.domain.feature.home.model.HomeSlider
import javax.inject.Inject

class HomeSliderMapper @Inject constructor() : EntityMapper<HomeSliderEntity, HomeSlider> {

    override fun mapFromEntity(entity: HomeSliderEntity) =
        HomeSlider(
            id = entity.id,
            title = entity.title,
            subtitle = entity.subtitle,
            description = entity.description,
            url = entity.url,
        )

    override fun mapToEntity(domain: HomeSlider) =
        HomeSliderEntity(
            id = domain.id,
            title = domain.title,
            subtitle = domain.subtitle,
            description = domain.description,
            url = domain.url,
        )
}