package com.andersen.internship.filmsapp.di.components

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.modules.BaseActivityModule
import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import dagger.Component

@Component(modules = arrayOf(BaseActivityModule::class))
@ActivityScope
interface BaseActivityComponent {

    fun sizeCalculator(): SizeCalculator
}