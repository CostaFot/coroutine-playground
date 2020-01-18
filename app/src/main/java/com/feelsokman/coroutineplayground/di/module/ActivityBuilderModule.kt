package com.feelsokman.coroutineplayground.di.module

import com.feelsokman.coroutineplayground.ui.activity.MainActivity
import com.feelsokman.coroutineplayground.ui.activity.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuilderModule::class])
    abstract fun mainActivity(): MainActivity
}
