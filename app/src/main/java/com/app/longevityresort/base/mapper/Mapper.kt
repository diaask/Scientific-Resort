package com.app.longevityresort.base.mapper

interface Mapper<out V, in D> {
    fun mapToView(type: D): V
}