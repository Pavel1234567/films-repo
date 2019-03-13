package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.network.api.FilmsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModelModule {

    @Singleton
    @Provides
    fun modelForFilms(filmsApi: FilmsApi): ModelFilmsRepository = ModelFilmsRepository(filmsApi)
}