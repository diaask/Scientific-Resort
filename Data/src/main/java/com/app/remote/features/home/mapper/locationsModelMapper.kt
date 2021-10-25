package com.app.remote.features.home.mapper

import com.app.data.features.home.model.LocationEntity
import com.app.remote.base.ModelMapper
import com.app.remote.features.home.model.LocationModel
import javax.inject.Inject

class locationsModelMapper @Inject constructor() : ModelMapper<LocationModel, LocationEntity> {

    override fun mapFromModel(model: LocationModel): LocationEntity {
        return LocationEntity(
            id = model.id,
            title = model.title,
            description = model.description,
            image = model.image
        )

    }

}