package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.FilterModule
import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.di.scopes.MainActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import dagger.Subcomponent

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class, FilterModule::class])
interface MainActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}
