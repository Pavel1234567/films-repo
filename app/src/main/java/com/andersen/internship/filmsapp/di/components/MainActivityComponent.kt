package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import dagger.Component

@ActivityScope
@Component(modules = arrayOf(MainActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface MainActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}