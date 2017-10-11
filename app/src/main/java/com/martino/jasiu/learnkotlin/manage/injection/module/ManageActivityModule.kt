package com.martino.jasiu.learnkotlin.manage.injection.module

import com.martino.jasiu.learnkotlin.manage.presentation.viewmodel.ManageActivityViewModel
import com.martino.jasiu.learnkotlin.manage.presentation.viewmodel.ManageActivityViewModelImpl
import dagger.Module
import dagger.Provides


@Module
class ManageActivityModule {

    @Provides
    fun provideViewModel() : ManageActivityViewModel {
        return ManageActivityViewModelImpl()
    }
}