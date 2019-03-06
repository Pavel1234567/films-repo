package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import com.andersen.internship.filmsapp.mvp.presenters.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @ActivityScope
    @Provides
    fun provideMainPresenter() = MainPresenter()
}