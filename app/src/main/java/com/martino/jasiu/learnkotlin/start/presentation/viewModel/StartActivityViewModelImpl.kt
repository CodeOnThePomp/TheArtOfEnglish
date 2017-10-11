package com.martino.jasiu.learnkotlin.start.presentation.viewModel

import android.util.Log


class StartActivityViewModelImpl : StartActivityViewModel {
    override fun logIsWorking() {
        Log.d("StartViewModel", "isWorking!!")
    }
}