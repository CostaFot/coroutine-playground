package com.feelsokman.coroutineplayground.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.feelsokman.coroutineplayground.BuildConfig
import com.feelsokman.coroutineplayground.coroutine.DefaultDispatcherProvider
import com.feelsokman.coroutineplayground.coroutine.DispatcherProvider
import com.feelsokman.coroutineplayground.repos.RedditRepository
import com.google.firebase.analytics.FirebaseAnalytics
import com.squareup.otto.Bus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun providesApplicationResources(context: Context): Resources {
        return context.resources
    }

    @Provides
    @Singleton
    fun providesBus(): Bus = Bus()

    @Provides
    fun providesFirebaseAnalytics(applicationContext: Context): FirebaseAnalytics {
        return FirebaseAnalytics.getInstance(applicationContext)
    }

    @Provides
    fun providesDebugFlag(): Boolean {
        return BuildConfig.DEBUG
    }

    @Singleton
    @Provides
    internal fun providesDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }

    @Provides
    fun providesRedditRepository(dispatcherProvider: DispatcherProvider): RedditRepository {
        return RedditRepository(dispatcherProvider)
    }
}
