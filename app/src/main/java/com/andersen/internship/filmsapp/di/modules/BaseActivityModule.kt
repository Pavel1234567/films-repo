package com.andersen.internship.filmsapp.di.modules

import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.ActivityScope
import com.andersen.internship.filmsapp.mvp.view.activities.BaseAppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule(private val baseAppCompatActivity: BaseAppCompatActivity) {

    @ActivityScope
    @Provides
    fun sizeCalculator() = SizeCalculator(baseAppCompatActivity)

}