package com.example.domain.interactor.base

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.disposables.Disposables
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Artur on 09.08.2017.
 */
abstract class CompletableUseCase<P> constructor(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread
) {
    private val subscription = CompositeDisposable()

    abstract fun build( params: P): Completable
    fun execute(observer: DisposableCompletableObserver, params: P) {
        val completableUse = build(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        subscription.add(completableUse.subscribeWith(observer))

    }

    fun dispose() {
        if (!subscription.isDisposed)
            subscription.dispose()
    }


}