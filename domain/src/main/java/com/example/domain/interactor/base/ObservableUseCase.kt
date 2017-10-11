package com.example.domain.interactor.base

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by Artur on 09.08.2017.
 */
abstract class ObservableUseCase<I, O> constructor(private val threadExecutor: ThreadExecutor,
                                                   private val postExecutionThread: PostExecutionThread){
    val disposable = CompositeDisposable()
    abstract fun build(params: O): Observable<I>

    fun execute(observer: DisposableObserver<I>, params: O) {
        val observableUse = build(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        disposable.add(observableUse.subscribeWith(observer))
    }

    fun dispose() {
        if(!disposable.isDisposed)
            disposable.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        this.disposable.add(disposable)
    }

}