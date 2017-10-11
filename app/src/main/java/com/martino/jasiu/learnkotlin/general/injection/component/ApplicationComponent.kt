package com.martino.jasiu.learnkotlin.general.injection.component

import android.app.Application
import com.martino.jasiu.learnkotlin.db.injection.DaoModule
import com.martino.jasiu.learnkotlin.general.injection.module.ApplicationModule
import com.martino.jasiu.learnkotlin.general.injection.module.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        DaoModule::class,
        ActivityBuilder::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: com.martino.jasiu.learnkotlin.Application)
}