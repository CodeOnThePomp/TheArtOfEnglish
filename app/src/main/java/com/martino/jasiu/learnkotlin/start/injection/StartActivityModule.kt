package com.martino.jasiu.learnkotlin.start.injection

import com.martino.jasiu.learnkotlin.start.presentation.viewModel.StartActivityViewModel
import com.martino.jasiu.learnkotlin.start.presentation.viewModel.StartActivityViewModelImpl
import dagger.Module
import dagger.Provides

@Module
class StartActivityModule {

    @Provides
    fun provideViewModel(): StartActivityViewModel {
        return StartActivityViewModelImpl()
    }

}
