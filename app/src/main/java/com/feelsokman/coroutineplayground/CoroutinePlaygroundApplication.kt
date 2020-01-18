package com.feelsokman.coroutineplayground

import androidx.appcompat.app.AppCompatDelegate
import com.feelsokman.coroutineplayground.di.AppComponent
import com.feelsokman.coroutineplayground.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class CoroutinePlaygroundApplication : DaggerApplication() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("Timber initialised")
        } else {
            Timber.e("You should not be seeing this!")
        }
        Timber.e("onCreate")
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent.builder().application(this).build()

        return component
    }
}
