package com.app.domain.base.executor

import io.reactivex.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}