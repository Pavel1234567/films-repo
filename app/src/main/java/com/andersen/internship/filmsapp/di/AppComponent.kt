package com.andersen.internship.filmsapp.di

import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import dagger.Component

@Component(modules = arrayOf(NetworkModule::class))
interface AppComponent {

    fun injectNetworkService(modelFilmsInterface: ModelFilmsInterface)
    fun injectMainModel(mainPresenter: MainPresenter)
}