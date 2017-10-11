package com.martino.jasiu.learnkotlin.mainmenu.injection.component

import com.martino.jasiu.learnkotlin.mainmenu.injection.module.MainMenuActivityModule
import com.martino.jasiu.learnkotlin.mainmenu.presentation.ui.MainMenuActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent( modules = arrayOf(MainMenuActivityModule:: class) )
interface MainMenuActivityComponent : AndroidInjector<MainMenuActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainMenuActivity> ()
}



