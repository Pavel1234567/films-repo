package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import com.andersen.internship.filmsapp.ui.adapters.FilmItemAdapter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @ActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository):FilmsPresenter{

        val filmsPresenter = FilmsPresenter(modelFilmsRepository)
        filmsPresenter.attachView(mainActivity)
        return filmsPresenter
    }

    @ActivityScope
    @Provides
    fun sizeCalculator() = SizeCalculator(mainActivity)

    @ActivityScope
    @Provides
    fun filmItemAdapter(sizeCalculator: SizeCalculator): FilmItemAdapter =
         FilmItemAdapter(sizeCalculator.calculateWidthAndHeightOfView())

}