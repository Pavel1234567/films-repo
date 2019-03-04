package com.andersen.internship.filmsapp

import android.app.Application
import com.andersen.internship.filmsapp.di.AppComponent
import com.andersen.internship.filmsapp.di.DaggerAppComponent
import timber.log.Timber

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.create()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
lateinit var component: AppComponent