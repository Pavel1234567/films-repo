package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AppModule::class, RepositoryModule::class, DatabaseModule::class])
@Singleton
interface AppComponent {

    fun baseActivityComponent(baseActivityModule: BaseActivityModule): BaseActivityComponent
}