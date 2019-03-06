package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.AppScope
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.models.MainModel
import com.andersen.internship.filmsapp.network.NetworkService
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @AppScope
    @Provides
    fun networkService(): NetworkService = NetworkService()

    @AppScope
    @Provides
    fun modelForFilms(): ModelFilmsInterface = MainModel()
}