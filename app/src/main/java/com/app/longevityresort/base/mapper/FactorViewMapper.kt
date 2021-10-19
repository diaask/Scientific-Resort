package com.app.longevityresort.base.mapper

import com.app.domain.feature.home.model.Factors
import com.app.longevityresort.base.model.FactorsView
import javax.inject.Inject

open class FactorViewMapper @Inject constructor() : Mapper<FactorsView, Factors> {

    override fun mapToView(type: Factors): FactorsView {
        return FactorsView(
            id = type.id,
            title = type.title,
            description = type.description,
            icon = type.icon
        )
    }
}