package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.BaseAppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule(private val baseAppCompatActivity: BaseAppCompatActivity) {

    @BaseActivityScope
    @Provides
    fun sizeCalculator() = SizeCalculator(baseAppCompatActivity)

}