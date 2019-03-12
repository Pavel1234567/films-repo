package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.DescriptionActivityModule
import com.andersen.internship.filmsapp.di.scopes.DescriptionActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.DescriptionActivity
import com.andersen.internship.filmsapp.mvp.view.activities.MainActivity
import dagger.Component

@DescriptionActivityScope
@Component(modules = arrayOf(DescriptionActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface DescriptionActivityComponent {
    fun injectDescriptionActivity(descriptionActivity: DescriptionActivity)
}