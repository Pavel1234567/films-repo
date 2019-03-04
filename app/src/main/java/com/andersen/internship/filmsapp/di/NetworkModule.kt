package com.andersen.internship.filmsapp.di

import com.andersen.internship.filmsapp.network.NetworkService
import com.andersen.internship.filmsapp.mvp.contracts.main.ModelFilmsInterface
import com.andersen.internship.filmsapp.mvp.models.MainModel
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
    fun modelForFilms(): ModelFilmsInterface = MainModel()
}