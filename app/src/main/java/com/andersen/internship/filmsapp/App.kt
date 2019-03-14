package com.andersen.internship.filmsapp

import android.app.Activity
import android.app.Application
import android.os.Build
import com.andersen.internship.filmsapp.di.components.BaseActivityComponent
import com.andersen.internship.filmsapp.di.components.DaggerAppComponent
import com.andersen.internship.filmsapp.di.components.MainActivityComponent
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.mvp.view.activities.BaseAppCompatActivity
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import com.google.android.gms.security.ProviderInstaller
import timber.log.Timber
import javax.net.ssl.SSLContext

class App: Application() {

    val appComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            solveSSLHandHandshakeError()
        }
    }

    private fun solveSSLHandHandshakeError(){
        ProviderInstaller.installIfNeeded(this)
        val sslContext = SSLContext.getInstance("TLSv1.2")
        sslContext.init(null, null, null)
    }
}

fun get(activity: Activity): App {
    return activity.application as App
}