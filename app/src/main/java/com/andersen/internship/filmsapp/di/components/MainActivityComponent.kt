package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import dagger.Component
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = arrayOf(MainActivityModule::class))
interface MainActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}
