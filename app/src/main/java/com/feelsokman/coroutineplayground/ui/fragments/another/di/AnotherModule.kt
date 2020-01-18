package com.feelsokman.coroutineplayground.ui.fragments.another.di

import com.feelsokman.coroutineplayground.ui.fragments.another.viewmodel.AnotherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AnotherModule {

    @Provides
    internal fun providesAnotherViewModelFactory() =
        AnotherViewModelFactory()
}
