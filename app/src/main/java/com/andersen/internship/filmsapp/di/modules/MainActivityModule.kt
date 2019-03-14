package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @MainActivityScope
    @Provides
    fun filmItemAdapter(sizeCalculator: SizeCalculator): FilmItemAdapter =
         FilmItemAdapter(sizeCalculator.calculateWidthAndHeightOfView())

    @MainActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository): FilmsPresenter =
        FilmsPresenter(modelFilmsRepository)
}