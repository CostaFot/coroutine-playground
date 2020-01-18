package com.feelsokman.coroutineplayground.di

import android.app.Application
import com.feelsokman.coroutineplayground.CoroutinePlaygroundApplication
import com.feelsokman.coroutineplayground.di.module.ActivityBuilderModule
import com.feelsokman.coroutineplayground.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<CoroutinePlaygroundApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
