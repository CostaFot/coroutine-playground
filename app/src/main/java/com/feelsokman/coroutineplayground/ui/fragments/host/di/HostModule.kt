package com.feelsokman.coroutineplayground.ui.fragments.host.di

import com.feelsokman.coroutineplayground.ui.fragments.host.viewmodel.HostViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HostModule {

    @Provides
    internal fun providesHostViewModelFactory() =
        HostViewModelFactory()
}
