package com.app.longevityresort.base.mapper

import com.app.domain.feature.home.model.Service
import com.app.longevityresort.base.model.ServiceView
import javax.inject.Inject

open class ServiceViewMapper @Inject constructor() : Mapper<ServiceView, Service> {

    override fun mapToView(type: Service): ServiceView {
        return ServiceView(
            id = type.id,
            title = type.title
        )
    }
}