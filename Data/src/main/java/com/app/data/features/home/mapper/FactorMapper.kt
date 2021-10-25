package com.app.data.features.home.mapper

import com.app.data.base.EntityMapper
import com.app.data.features.home.model.FactorsEntity
import com.app.domain.feature.home.model.Factors
import javax.inject.Inject

class FactorMapper @Inject constructor() : EntityMapper<FactorsEntity, Factors> {

    override fun mapFromEntity(entity: FactorsEntity) =
        Factors(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            icon = entity.icon
        )

    override fun mapToEntity(domain: Factors) =
        FactorsEntity(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            icon = domain.icon,
        )
}