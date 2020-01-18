package com.feelsokman.androidtemplate.ui.fragments.another.di

import com.feelsokman.androidtemplate.ui.fragments.another.viewmodel.AnotherViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AnotherModule {

    @Provides
    internal fun providesAnotherViewModelFactory() =
        AnotherViewModelFactory()
}
