package com.app.domain.base.interactor

import com.app.domain.base.result.AResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<R, in P>(private val coroutineDispatcher: CoroutineDispatcher) {

    /** Executes the use case asynchronously and returns a [Result].
     *
     * @return a [Result].
     *
     * @param params the input parameters to run the use case with
     */
    suspend operator fun invoke(params: P): Flow<AResult<R>> {
        return flow {
            try {
                withContext(coroutineDispatcher) {
                    execute(params).let {
                        AResult.Success(it)
                    }
                }
            } catch (e: Exception) {
                AResult.Error(e)
            }
        }
    }

    /**
     * Override this to set the code to be executed.
     */
    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: P): R
}
