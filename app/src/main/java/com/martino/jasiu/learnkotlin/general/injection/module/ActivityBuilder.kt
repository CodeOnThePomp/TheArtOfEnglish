package com.martino.jasiu.learnkotlin.general.injection.module

import android.app.Activity
import com.martino.jasiu.learnkotlin.mainmenu.injection.component.MainMenuActivityComponent
import com.martino.jasiu.learnkotlin.mainmenu.presentation.ui.MainMenuActivity
import com.martino.jasiu.learnkotlin.manage.injection.component.ManageActivityComponent
import com.martino.jasiu.learnkotlin.manage.presentation.ui.ManageActivity
import com.martino.jasiu.learnkotlin.start.injection.StartActivityComponent
import com.martino.jasiu.learnkotlin.start.presentation.ui.StartActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainMenuActivity::class)
    abstract fun bindMainMenuActivity(builder: MainMenuActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(StartActivity::class)
    abstract fun bindStartActivity(builder: StartActivityComponent.Builder): AndroidInjector.Factory<out Activity>

    @Binds
    @IntoMap
    @ActivityKey(ManageActivity::class)
    abstract fun bindManageActivity(builder: ManageActivityComponent.Builder): AndroidInjector.Factory<out Activity>


}