package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.models.FilterFilms
import dagger.Module
import dagger.Provides

@Module
class FilterModule {

    @MainActivityScope
    @Provides
    fun filterFilms() = FilterFilms()
}