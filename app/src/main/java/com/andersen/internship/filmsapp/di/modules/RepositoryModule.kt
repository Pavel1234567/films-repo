package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.network.api.FilmsApi
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun modelForFilms(filmsApi: FilmsApi): ModelFilmsRepository{
        Timber.tag("myLogs").d("ModelFilmsRepository created ${this.hashCode()}")

        return ModelFilmsRepository(filmsApi)
    }
}