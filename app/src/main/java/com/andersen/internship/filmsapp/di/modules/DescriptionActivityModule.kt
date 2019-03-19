package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.DescriptionActivityScope
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmDescriptionPresenter
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import com.andersen.internship.filmsapp.mvp.view.activities.DescriptionActivity
import dagger.Module
import dagger.Provides

@Module
class DescriptionActivityModule(private val descriptionActivity: DescriptionActivity) {

    @Provides
    @DescriptionActivityScope
    fun selectedItemId() = descriptionActivity.intent.getIntExtra(MainActivityModule.ITEM_POSITION, -1)

    @DescriptionActivityScope
    @Provides
    fun provideMainPresenter(modelFilmsRepository: ModelFilmsRepository, selectedItemId: Int): FilmDescriptionPresenter =
        FilmDescriptionPresenter(modelFilmsRepository, selectedItemId)

}