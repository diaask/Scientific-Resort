package com.app.remote.features.home.mapper

import com.app.data.features.home.model.ServiceEntity
import com.app.remote.base.ModelMapper
import com.app.remote.features.home.model.ServiceModel
import javax.inject.Inject

class ServiceModelMapper @Inject constructor() : ModelMapper<ServiceModel, ServiceEntity> {

    override fun mapFromModel(model: ServiceModel): ServiceEntity {
        return ServiceEntity(
            id = model.id,
            title = model.title
        )
    }
}