package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.AppModule
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.di.modules.NetworkModule
import com.andersen.internship.filmsapp.mvp.models.ModelFilmsRepository
import com.andersen.internship.filmsapp.mvp.presenters.FilmsPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(NetworkModule::class, AppModule::class))
@Singleton
interface AppComponent {

    fun baseActivityComponent(baseActivityModule: BaseActivityModule): BaseActivityComponent
}