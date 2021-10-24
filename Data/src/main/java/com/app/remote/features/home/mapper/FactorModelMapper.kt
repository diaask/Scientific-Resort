package com.app.remote.features.home.mapper

import com.app.data.features.home.model.FactorsEntity
import com.app.remote.base.ModelMapper
import com.app.remote.features.home.model.FactorsModel
import javax.inject.Inject

class FactorModelMapper @Inject constructor() : ModelMapper<FactorsModel, FactorsEntity> {

    override fun mapFromModel(model: FactorsModel): FactorsEntity {
        return FactorsEntity(
            id = model.id,
            title = model.title,
            description = model.description,
            icon = model.icon
        )

    }

}