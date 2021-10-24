package com.app.domain.base.interactor

import com.app.domain.base.result.AResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

/**
 * Executes business logic in its execute method and keep posting updates to the result as
 * [Result<R>].
 * Handling an exception (emit [Result.Error] to the result) is the subclasses's responsibility.
 */
abstract class FlowUseCase<R, in P>(val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(params: P): Flow<AResult<R>> = execute(params)
        .catch { e -> emit(AResult.failure(Exception(e))) }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(params: P): Flow<AResult<R>>
}
