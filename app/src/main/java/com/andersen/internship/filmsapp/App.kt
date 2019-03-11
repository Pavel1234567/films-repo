package com.andersen.internship.filmsapp

import android.app.Application
import android.os.Build
import com.andersen.internship.filmsapp.di.components.AppComponent
import com.andersen.internship.filmsapp.di.components.DaggerAppComponent
import com.google.android.gms.security.ProviderInstaller
import timber.log.Timber
import javax.net.ssl.SSLContext

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }


        if (android.os.Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            solveSSLHandHandshakeError()
        }

        component = DaggerAppComponent.create()

        val model = component.getModel()

        Timber.tag("myLog").d("App model ${model.hashCode()}")
        Timber.tag("myLog").d("App networkService ${model.networkService.hashCode()}")


    }

    private fun solveSSLHandHandshakeError(){
        ProviderInstaller.installIfNeeded(this)
        val sslContext = SSLContext.getInstance("TLSv1.2")
        sslContext.init(null, null, null)
    }

}
lateinit var component: AppComponent