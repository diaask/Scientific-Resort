package com.app.data.features.home.mapper

import com.app.data.base.EntityMapper
import com.app.data.features.home.model.LocationEntity
import com.app.domain.feature.home.model.Location
import javax.inject.Inject

class LocationsMapper @Inject constructor() : EntityMapper<LocationEntity, Location> {

    override fun mapFromEntity(entity: LocationEntity) =
        Location(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            image = entity.image
        )

    override fun mapToEntity(domain: Location) =
        LocationEntity(
            id = domain.id,
            title = domain.title,
            description = domain.description,
            image = domain.image,
        )
}