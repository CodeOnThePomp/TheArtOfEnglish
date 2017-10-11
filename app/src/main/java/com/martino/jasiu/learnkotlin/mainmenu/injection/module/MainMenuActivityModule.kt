package com.martino.jasiu.learnkotlin.mainmenu.injection.module

import com.martino.jasiu.learnkotlin.mainmenu.presentation.viewmodel.MainMenuActivityViewModel
import com.martino.jasiu.learnkotlin.mainmenu.presentation.viewmodel.MainMenuActivityViewModelImpl
import dagger.Module
import dagger.Provides


@Module
class MainMenuActivityModule {

    @Provides
    fun provideViewModel() : MainMenuActivityViewModel {
        return MainMenuActivityViewModelImpl()
    }

}