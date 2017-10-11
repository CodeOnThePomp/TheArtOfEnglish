package com.martino.jasiu.learnkotlin.general.injection.module

import android.app.Application
import android.content.Context
import com.martino.jasiu.learnkotlin.db.dao.WordDao
import com.martino.jasiu.learnkotlin.mainmenu.injection.component.MainMenuActivityComponent
import com.martino.jasiu.learnkotlin.mainmenu.presentation.ui.MainMenuActivity
import com.martino.jasiu.learnkotlin.manage.injection.component.ManageActivityComponent
import com.martino.jasiu.learnkotlin.start.injection.StartActivityComponent
import dagger.Module
import javax.inject.Singleton
import dagger.Provides



@Module(subcomponents = arrayOf(
        StartActivityComponent :: class,
        MainMenuActivityComponent :: class,
        ManageActivityComponent :: class
))
class ApplicationModule{

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

}
