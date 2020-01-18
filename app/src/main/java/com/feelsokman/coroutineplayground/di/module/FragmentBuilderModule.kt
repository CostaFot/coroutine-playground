package com.feelsokman.coroutineplayground.di.module

import com.feelsokman.coroutineplayground.ui.fragments.another.AnotherFragment
import com.feelsokman.coroutineplayground.ui.fragments.another.di.AnotherModule
import com.feelsokman.coroutineplayground.ui.fragments.host.HostFragment
import com.feelsokman.coroutineplayground.ui.fragments.host.di.HostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [HostModule::class])
    abstract fun hostFragment(): HostFragment

    @ContributesAndroidInjector(modules = [AnotherModule::class])
    abstract fun anotherFragment(): AnotherFragment
}
