package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @MainActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository): FilmsPresenter =
        FilmsPresenter(modelFilmsRepository)
}