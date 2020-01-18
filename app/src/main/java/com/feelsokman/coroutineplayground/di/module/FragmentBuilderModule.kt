package com.feelsokman.coroutineplayground.di.module

import com.feelsokman.coroutineplayground.ui.fragments.another.AnotherFragment
import com.feelsokman.coroutineplayground.ui.fragments.another.di.AnotherModule
import com.feelsokman.coroutineplayground.ui.fragments.post.PostFragment
import com.feelsokman.coroutineplayground.ui.fragments.post.di.PostModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun postFragment(): PostFragment

    @ContributesAndroidInjector(modules = [AnotherModule::class])
    abstract fun anotherFragment(): AnotherFragment
}
