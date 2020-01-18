package com.feelsokman.coroutineplayground.ui.activity.di

import com.feelsokman.coroutineplayground.ui.activity.viewmodel.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    internal fun providesMainViewModelFactory() =
        MainViewModelFactory()
}
