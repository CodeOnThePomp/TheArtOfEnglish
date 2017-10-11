package com.martino.jasiu.learnkotlin.start.injection

import com.martino.jasiu.learnkotlin.start.presentation.ui.StartActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent( modules = arrayOf(StartActivityModule :: class) )
interface StartActivityComponent : AndroidInjector<StartActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<StartActivity> ()
}

