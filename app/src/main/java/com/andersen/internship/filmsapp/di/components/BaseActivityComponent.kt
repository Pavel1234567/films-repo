package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.di.modules.MainActivityModule
import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.BaseAppCompatActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(BaseActivityModule::class))
@BaseActivityScope
interface BaseActivityComponent {

    fun injectBaseActivity(baseAppCompatActivity: BaseAppCompatActivity)
    fun mainActivityComponent(mainActivityModule: MainActivityModule): MainActivityComponent
}