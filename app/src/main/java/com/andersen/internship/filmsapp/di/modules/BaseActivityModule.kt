package com.andersen.internship.filmsapp.di.modules

import android.content.Context
import com.andersen.internship.filmsapp.SizeCalculator
import com.andersen.internship.filmsapp.di.scopes.BaseActivityScope
import dagger.Module
import dagger.Provides

@Module
class BaseActivityModule {

    @BaseActivityScope
    @Provides
    fun sizeCalculator(context: Context) = SizeCalculator(context.resources)
}