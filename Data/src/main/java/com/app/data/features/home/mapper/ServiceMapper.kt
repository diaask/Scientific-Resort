package com.app.data.features.home.mapper

import com.app.data.base.EntityMapper
import com.app.data.features.home.model.ServiceEntity
import com.app.domain.feature.home.model.Service
import javax.inject.Inject

class ServiceMapper @Inject constructor() : EntityMapper<ServiceEntity, Service> {

    override fun mapFromEntity(entity: ServiceEntity) =
        Service(
            id = entity.id,
            title = entity.title
        )

    override fun mapToEntity(domain: Service) =
        ServiceEntity(
            id = domain.id,
            title = domain.title
        )
}