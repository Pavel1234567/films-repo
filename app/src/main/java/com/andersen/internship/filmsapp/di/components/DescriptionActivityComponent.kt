package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.di.modules.DescriptionActivityModule
import com.andersen.internship.filmsapp.di.scopes.DescriptionActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.DescriptionActivity
import dagger.Subcomponent

@DescriptionActivityScope
@Subcomponent(modules = [DescriptionActivityModule::class])

interface DescriptionActivityComponent {
    fun injectDescriptionActivity(descriptionActivity: DescriptionActivity)
}