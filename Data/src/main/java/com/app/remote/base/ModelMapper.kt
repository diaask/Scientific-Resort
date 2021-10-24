package com.app.remote.base

interface ModelMapper<in M, out E> {

    fun mapFromModel(model: M): E

}