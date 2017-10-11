package com.example.domain.executor

import io.reactivex.Scheduler

/**
 * Created by Artur on 11.09.2017.
 */
interface PostExecutionThread {
    val scheduler: Scheduler
}