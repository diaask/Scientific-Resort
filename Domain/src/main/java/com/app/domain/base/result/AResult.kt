package com.app.domain.base.result

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class AResult<out R> {
    data class success<out T>(val data: T) : AResult<T>()
    data class failure(val exception: Exception) : AResult<Nothing>()
    object Loading : AResult<Nothing>()
}

val <T> AResult<T>.data: T?
    get() = (this as? AResult.success)?.data