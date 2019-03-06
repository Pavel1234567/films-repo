package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.NetworkModule
import com.andersen.internship.filmsapp.di.scopes.AppScope
import com.andersen.internship.filmsapp.mvp.models.MainModel
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import dagger.Component

@Component(modules = arrayOf(NetworkModule::class))
@AppScope
interface AppComponent {

    fun injectNetworkService(modelFilmsInterface: MainModel)
    fun injectMainModel(mainPresenter: MainPresenter)
}