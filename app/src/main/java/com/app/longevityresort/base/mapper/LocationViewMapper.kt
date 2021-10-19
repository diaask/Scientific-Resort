package com.app.longevityresort.base.mapper

import com.app.domain.feature.home.model.Location
import com.app.longevityresort.base.model.LocationView
import javax.inject.Inject

open class LocationViewMapper @Inject constructor() : Mapper<LocationView, Location> {

    override fun mapToView(type: Location): LocationView {
        return LocationView(
            id = type.id,
            title = type.title,
            description = type.description,
            image = type.image,
        )
    }
}