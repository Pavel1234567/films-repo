package com.andersen.internship.filmsapp.di

import com.andersen.internship.filmsapp.mvp.models.MainModel
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(NetworkModule::class))
@Singleton
interface AppComponent {

    fun injectNetworkService(modelFilmsInterface: MainModel)
    fun injectMainModel(mainPresenter: MainPresenter)
}