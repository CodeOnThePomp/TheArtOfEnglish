package com.example.domain.interactor.base

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Artur on 27.07.2017.
 */
abstract class SingleUseCase<I, O>(
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread) {
    private val disposable = CompositeDisposable()
    abstract fun build(params: O?): Single<I>
    open fun execute(observer : DisposableSingleObserver<I>, params : O? = null){
        val singleUse = build(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        disposable.add(singleUse.subscribeWith(observer))
    }
    fun dispose() {
        if (!disposable.isDisposed)
            disposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }

}