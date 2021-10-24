package com.app.data.base

interface EntityMapper<E, D> {

    fun mapFromEntity(entity: E): D

    fun mapToEntity(domain: D): E

}