package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.network.NetworkService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun networkService(): NetworkService = NetworkService()

    @Singleton
    @Provides
    fun modelForFilms(networkService: NetworkService): ModelFilmsRepository = ModelFilmsRepository(networkService)


}