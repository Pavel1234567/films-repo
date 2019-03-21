package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.AppModule
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.di.modules.NetworkModule
import com.andersen.internship.filmsapp.di.modules.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(NetworkModule::class, AppModule::class, RepositoryModule::class))
@Singleton
interface AppComponent {

    fun baseActivityComponent(baseActivityModule: BaseActivityModule): BaseActivityComponent
}