package com.martino.jasiu.learnkotlin.manage.injection.component

import com.martino.jasiu.learnkotlin.manage.injection.module.ManageActivityModule
import com.martino.jasiu.learnkotlin.manage.presentation.ui.ManageActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(ManageActivityModule::class))
interface ManageActivityComponent : AndroidInjector<ManageActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<ManageActivity>()
}